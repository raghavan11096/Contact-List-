var _options = {
    '_license_key':'999-587-515',
    '_role_token':'d9dd6a1f46965843abe286ed9ca0a365',
    '_registrant_token':'',
    '_widget_containerID':'embedWidget',
    '_widget_width':'100%',
    '_widget_height':'100vh',
    '_password_token':'',
    '_nickname':'',
    '_avatar_url':'',
};
(function() {
    !function(i){
        i.Widget=function(c){
            'function'==typeof c&&i.Widget.__cbs.push(c),
            i.Widget.initialized&&(i.Widget.__cbs.forEach(function(i){i()}),
                i.Widget.__cbs=[])
        },
            i.Widget.__cbs=[]
    }(window);
    var ab = document.createElement('script');
    ab.type = 'text/javascript';
    ab.async = true;
    ab.src = 'https://embed.livewebinar.com/em?t='+_options['_license_key']+'&'+Object.keys(_options).reduce(function(a,k){
        a.push(k+'='+encodeURIComponent(_options[k]));
        return a
    },[]).join('&');
    var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ab, s);
})();
