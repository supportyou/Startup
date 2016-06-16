(function (global, factory) {

    if (typeof module === 'object' && typeof module.exports === 'object') {

        module.exports = global.document ?
            factory(global, true) :
            function (w) {
                if (!w.document) {
                    throw new Error('kr-ad-sys requires a window with document');
                }

                return factory(w);
            };
    } else {
        factory(global);
    }
})((typeof window !== 'undefined' ? window : this), function (global, noGlobal) {
    var KrAdLoader = {};
    var XHR_URL = '//36kr.com/pp/api/ap-plan' || '36kr.com';
    var XHR_PRE_URL =  '//ad.corp.36kr.com/preview' || '';


    function getHTML(id, fn){
        if(isPreview(id)){
            getPreHTML(id, fn);
        }else{
            getSysHTML(id, fn);
        }
    }

    function getALL(id, fn){
        if(isPreview(id)){
            getPreHTML(id, fn, true);
        }else{
            getSysHTML(id, fn, true);
        }
    }

    function renderByDom(el, fn){
        var id = $(el).data('kr-showcase-id');
        var _fn = function(content, err){
            fn && fn(content, err);
            $(el).html(content);
            //$(window).scrollTop($(el).offset().top);
        }

        if(!id){
            _fn('');
        }else{
            getHTML(id, _fn)
        }

    }


    function getPreHTML(id, fn, all){
        getContent(id, fn, true, all)
    }

    function getSysHTML(id, fn, all){
        getContent(id, fn, false, all);
    }

    function renderAd(tpl, definition, materiel) {
        var result = tpl;
        var keys = Object.keys(definition).forEach(function(key){
            var type = definition[key].type;
            var size = definition[key].size;
            var data = materiel[key];
            if(!data) {
                if(type==='img'){
                    data = 'http://placekitten.com/' + size[0] + '/' + size[1];
                }else{
                    data = '广告系统示例文字';
                }
            }
            result = result.replace('{{'+key+'}}', data);
        });
        return result;
    }

    function getContent(id, fn, isPreview, isAll){
        var url = isPreview ? XHR_PRE_URL : XHR_URL;

        if(isPreview) {
            $.ajax({
                url:url + '/' + getUrlParams('key'),
                dataType: 'jsonp',
                success: function(data){
                    var tpl = data.content;
                    var definition = JSON.parse(data.definition);
                    var materiel = data.materielData || {};
                    var html = renderAd(tpl, definition, materiel);
                    fn && fn(html || '');
                },
                error:function(){
                    fn && fn('', true);
                }
            });
            return;
        }


        $.ajax({
            url:url,
            data:{pids:id},
            dataType: 'jsonp',
            success: function(data){
                data = data.data || [];
                if(!data.length){
                    return fn && fn('');
                }
                if(isAll){
                    var ad = data && data[0];
                    setLinkTrack(ad);
                    return fn && fn(data[0] || '');
                }
                fn && fn(data[0].html || '');
            },
            error:function(){
                fn && fn('', true);
            }
        });

        function setLinkTrack(data){
            var ad = data && data.ad;
            var materiel = ad && ad.materiels && ad.materiels[0];
            var definition = ad.template && ad.template.definition;
            var materielData = materiel && materiel.data;
            if(!materielData){
                return ad;
            }
            try {
                materielData = JSON.parse(materielData);
                definition = JSON.parse(definition);
                Object.keys(materielData).forEach(function(key){
                    var arr = key.split('#');
                    var originKey = arr[0];
                    var index = arr[1];
                    var REGLink = /http(s?):\/\/.+$/;
                    var type = definition[originKey] && definition[originKey].type;
                    var val = materielData[key];
                    var isListLink = index && val.match(REGLink) && type!=='img';
                    if(isListLink){
                        materielData[key] = val.indexOf('?')>-1?(val + '&st_index='+index):(val + '?st_index='+index);
                        materiel.data = JSON.stringify(materielData);
                    }
                });
            }catch(e){

            }
            return ad;
        }
    }

    //判断是否是preview
    function isPreview(id){
        var previewKey = getUrlParams('key');
        //adSysPreviewIds=1,2,3
        var preIds = getUrlParams('adSysPreviewIds') || '';
        var shouldPreview = (preIds.split(',').indexOf(id+'') !== -1);
        return previewKey && shouldPreview;
    }

    //获取浏览器参数
    function getUrlParams(name){
        var reg = new RegExp("(^|&)"+ name +"=([^&]*)(&|$)");
        var r = window.location.search.substr(1).match(reg);
        if(r!=null)return  decodeURIComponent(r[2]); return null;
    }

    KrAdLoader.renderByDom = renderByDom;
    KrAdLoader.getHTML = getHTML;
    KrAdLoader.getALL = getALL;

    if ( !noGlobal ) {
        window.KrAdLoader = KrAdLoader;

    }
    return KrAdLoader;
});
