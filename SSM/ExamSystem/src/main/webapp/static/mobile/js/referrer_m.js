(function(e){var g=document,w=e.location;if(!e.TJ58){e.TJ58=!0;null==e.String.prototype.trim&&(e.String.prototype.trim=function(){return this.replace(/^\s\s*/,"").replace(/\s\s*$/,"")});var f={curURL:w.href,referrer:g.referrer,protocol:w.protocol,window_size:g.documentElement.clientWidth+"x"+g.documentElement.clientHeight,screen_size:e.screen.width+","+e.screen.height,domain:function(){var a=w.host.toLowerCase(),b=/.*?([^\.]+\.(com|org|net|biz|edu|cc)(\.[^\.]+)?)/;return b.test(a)?"."+a.replace(b,
"$1"):""}(),navigation_type:function(){var a="-1";try{a=e.performance.navigation.type}catch(b){return"-1"}return a}(),setCookie:function(){if(!g.cookie)return!1;var a=new Date;2<arguments.length?a.setTime(a.getTime()+864E5*arguments[2]):a.setTime(a.getTime()+18E5);2<=arguments.length&&(g.cookie=arguments[0]+"="+escape(arguments[1])+"; expires="+a.toGMTString()+"; domain="+f.domain+"; path=/")},getCookie:function(a){if(!g.cookie)return"";var b;return(b=g.cookie.match(RegExp("(^| )"+a+"=([^;]*)(;|$)")))?
unescape(b[2]):""},ajaxsend:function(a){(new Image).src=a},getGTID:function(a,b,c){function f(a,b,c){a=(""+a).length<b?(Array(b+1).join("0")+a).slice(-b):""+a;return-1==c?a:a.substring(0,c)+"-"+a.substring(c)}var q={home:"1",index:"2",list:"3",detail:"4",post:"5",special:"6"};a=q[a]?parseInt(q[a]).toString(16):0;b=b.split(",");b=b[b.length-1];b=parseInt(b)?parseInt(b).toString(16):0;c=c.split(",");c=c[c.length-1];c=parseInt(c)?parseInt(c).toString(16):0;q=(13).toString(16);return"llpccccc-tttt-txxx-xxxx-xxxxxxxxxxxx".replace(/x/g,
function(a){return(16*Math.random()|0).toString(16)}).replace(/ccccc/,f(b,5,-1)).replace(/tttt-t/,f(c,5,4)).replace(/p/,f(a,1,-1)).replace(/ll/,f(q,2,-1))},setLocalStorage:function(a,b){try{e.localStorage&&e.localStorage.setItem(a,b)}catch(c){}},getLocalStorage:function(a){try{return e.localStorage?e.localStorage.getItem(a):""}catch(b){return""}},getUUID:function(a){var b="xxxxxxxx-xxxx-4xxx-yxxx-xxxxxxxxxxxx".replace(/[xy]/g,function(a){var b=16*e.Math.random()|0;return("x"==a?b:b&3|8).toString(16)}),
b=this.getCookie(a)||this.getLocalStorage(a)||b;this.setCookie(a,b,365);this.setLocalStorage(a,b);return b},getRandom:function(){return e.Math.random()},bindElem:function(a,b,c){if(e.$&&"string"==typeof a&&"string"==typeof b&&"function"==typeof c)if("function"===typeof $(g).on)$(g).on(b,a,c);else"function"===typeof $(g).delegate?$(g).delegate(a,b,c):"function"===typeof $(a).bind&&$(a).bind(b,c)},loadScript:function(a,b){try{var c=g.createElement("script");c.type="text/javascript";c.readyState?c.onreadystatechange=
function(){if("loaded"==c.readyState||"complete"==c.readyState)c.onreadystatechange=null,b&&b()}:c.onload=function(){b&&b()};c.src=a;g.body.appendChild(c)}catch(f){}}},d={config:{trackLog:{server:"tracklog.58.com/m/empty.js.gif",allParams:"site_name tag referrer post_count _trackParams userid smsc window_size _ga_utma trackURL rand_id".split(" "),uniqParams:["tag","rand_id"]},loadMorePageLog:{server:"tracklog.58.com/m/empty.js.gif",allParams:"site_name tag referrer post_count _trackParams userid smsc window_size _ga_utma trackURL EventTag rand_id".split(" "),
uniqParams:["tag","EventTag","rand_id"]},listShowLog:{server:"tracklog.58.com/Mv1/listshow/empty.js.gif",allParams:"tag bangbangid referrer site_name info_data trackURL rand_id".split(" "),uniqParams:["tag","info_data","rand_id"]},listClickLog:{server:"tracklog.58.com/Mv1/listclick/empty.js.gif",allParams:"tag bangbangid referrer site_name info_data trackURL ClickID rand_id".split(" "),uniqParams:["tag","info_data","rand_id"]},clickLog:{server:"tracklog.58.com/m/click/empty.js.gif",allParams:"site_name tag from trackURL ClickID bangbangid referrer rand".split(" "),
uniqParams:["tag","from","rand"]},diaTrackLog:{server:"dialog.58.com/transfer",allParams:"DIATag referrer post_count _trackParams userid smsc window_size _ga_utma trackURL rand_id".split(" "),uniqParams:["DIATag","rand_id"]},diaClickLog:{server:"dialog.58.com/transfer",allParams:"DIATag from trackURL ClickID bangbangid referrer rand".split(" "),uniqParams:["DIATag","from","rand"]},diaShowLog:{server:"dialog.58.com/transfer",allParams:"DIATag trackURL ClickID bangbangid referrer rand".split(" "),uniqParams:["DIATag",
"rand"]},gdtTrackLog:{server:"gdt.cm.58.com/gdtcm",allParams:["city","cate","plat"],uniqParams:["city","plat"]}},filterList:function(a){var b=".58.com.cn portal.58.com faw-vw-dasweltauto.58.com 5858.com lieche.58.com dict.58.com/xiaoqu about.58.com m.58.com/city.html lieche.m.58.com".split(" "),c;for(c in b)if(-1!==a.indexOf(b[c]))return"YES";return"NO"},isRealIndexPage:function(a){var b=[/^http:\/\/m.58.com\/[^\/]*\/job.shtml/,/^http:\/\/m.58.com\/[^\/]*\/house.shtml/,/^http:\/\/m.58.com\/[^\/]*\/car.shtml/,
/^http:\/\/m.58.com\/[^\/]*\/sale.shtml/,/^http:\/\/m.58.com\/[^\/]*\/jianzhi.shtml/,/^http:\/\/m.58.com\/[^\/]*\/pets.shtml/,/^http:\/\/m.58.com\/[^\/]*\/shenghuo.shtml/,/^http:\/\/m.58.com\/[^\/]*\/bendishenghuo.shtml/,/^http:\/\/m.58.com\/[^\/]*\/bendishangwu.shtml/,/^http:\/\/m.58.com\/[^\/]*\/huangye.shtml/],c;for(c in b)if(a.match(b[c]))return"YES";return"NO"},getBaseInfo:function(){var a=e.site_name||"M58",b=e.encodeURIComponent(f.referrer),c=f.curURL,K=f.getUUID("58tj_uuid"),q=f.getCookie("bangbangid"),
A=f.window_size,n=f.navigation_type,l=f.screen_size,h=e.____json4fe?e.____json4fe:{},d=h._trackPagetype||"",k=h._trackURL||"",g=h._trackParams||[],w=h.GA_pageview||"",N=h.infoid||"",O=h.userid||"",P=h.smsc||"",h=h.sid||"",u=e._trackURL||k||"NA",r={};try{r="NA"===u?{}:eval("("+u+")")}catch(V){r={}}var d=r.pagetype||d||e.page_type||"NA",k=r.post_count||e.post_count||-1,w=r.Ga_pageview||w||"",x=r.cate||"",Q=""===x?"":x.split(",")[0],R=""===x&&-1===x.indexOf(",")?"":x.split(",")[1],D=r.area||"",L=""===
D?"":D.split(",")[0],S=r.actiontype||"",M=f.getGTID(d,x,D),r=r.ROI||"",T=f.getCookie("br58")||"",G=f.getCookie("myLat")||"",p=f.getCookie("myLon")||"",G=G+"_"+p,p=e._trackParams||g||[],y=[],g="";if(p instanceof Array){for(var g=0,H=p.length;g<H;g++)p[g]&&p[g].I&&p[g].V&&"string"===typeof p[g].V&&y.push(p[g].I+":"+p[g].V.replace(/\|/g,"*"));g=encodeURIComponent(y.join("@@"))}var y=(p=f.curURL.match(/[\?&]iuType=[a-z]*_[0-9]*/))?p[0].split("=")[1].split("_"):["",""],p=y[0],y=y[1],H=f.getCookie("als"),
I=f.getCookie("utm_source"),U=f.getCookie("utm_campaign"),J=f.getCookie("spm"),z,B,E;""!=f.getCookie("new_session")?(z=f.getCookie("init_refer"),B="0"):(z=e.encodeURIComponent(f.referrer),B="1");E=""!=f.getCookie("new_uv")?parseInt(f.getCookie("new_uv"))+("0"==B?0:1):1;f.setCookie("new_session",B);f.setCookie("new_uv",E,365);var s=!1,C=f.referrer.split("/")[2]||"",t=this.getValByUrl(f.curURL,"utm_source"),v=this.getValByUrl(f.curURL,"spm");"NA"!=this.getValByUrl(f.curURL,"-15")&&(s="NA");f.referrer||
"NA"==t&&"NA"==v?f.referrer||"NA"!=t||"NA"!=v||"1"!==B?C&&-1===C.indexOf(".58.com")&&-1===C.indexOf(".5858.com")&&-1===C.indexOf(".58cdn.com.cn")&&(z=e.encodeURIComponent(f.referrer),s="NA"==s?!1:!0):(z="",s="NA"==s?!1:!0):(z="",s="NA"==s?!1:!0);s&&"NA"!=s&&(I="NA"===t?"":t,J="NA"===v?"":v);f.setCookie("utm_source",I);f.setCookie("spm",J);f.setCookie("init_refer",z);var s="1.1.1.1.1."+E,C=f.getCookie("bbsession_uid"),t=[],v=u.indexOf("{"),n={GTID:M,infoid:N,infotype:p,usertype:y,als:H,utm_source:I,
utm_campaign:U,spm:J,br58:T,coords:G,new_session:B,init_refer:z,new_uv:E,UUID:K,bangbangid:C,navtype:n,sc:l,sid:h},F;for(F in n)n.hasOwnProperty(F)&&t.push("'"+F+"':'"+n[F]+"'");t.join(",");u="NA"!==u&&-1!==v?u.substring(0,v+1)+t+","+u.substring(v+1):"{"+t+"}";return{site_name:a,referrer:b,UUID:K,bangbangid:q,pagetype:d,post_count:k,cate:x,cate1:Q,cate2:R,area:D,area1:L,city:L,actiontype:S,GTID:M,ClickID:1,ROI:r,curURL:c,_trackParams:g,userid:O,smsc:P,window_size:A,trackURL:u,Ga_pageview:w,_ga_utma:s,
ClickIDPlus:function(){this.ClickID+=1},curIndex:0,curPageNum:1}},getValByUrl:function(a,b){var c;c=a.match(RegExp("[&?]"+b+"=([^&|^#]*)"));return c instanceof Array?c[1]:"NA"},sendLog:function(a,b){var c=this.baseInfo,e=this.config[a];if(a&&e&&b&&"object"===typeof b){for(var q=[],A=e.allParams,n=0,d=A.length;n<d;n++)q.push(A[n]+"="+(b[A[n]]||c[A[n]]||""));f.ajaxsend(f.protocol+"//"+e.server+"?"+q.join("&"))}},trackLog:function(){var a=this.baseInfo;this.sendLog("trackLog",{tag:"pvstatall",rand_id:f.getRandom()});
if("list"===a.pagetype){var b=a.Ga_pageview.indexOf("?key=");-1!==b&&a.Ga_pageview.substring(b+5);this.sendLog("gdtTrackLog",{city:a.area,plat:"M"})}},clickLog:function(a){var b="",b=null!=a&&"from="===a.substring(0,5)?a.replace("from=",""):"default&"+a;this.sendLog("clickLog",{tag:"pvsiters",from:b,rand:f.getRandom()});setTimeout("GCIDPlus()",300)},listClickLog:function(){var a=this,b=this.baseInfo;if(e.$&&"list"===b.pagetype&&"NA"!=b.trackURL){var c=function(c){if(c){var e=$(c).parents("[logr]");
c=e.attr("logr");var d="",d="";if(c){var g=[];c=c.split("_");g.push(c[0],c[1],c[2],c[3]);if(4<c.length)var h=c[c.length-1],h=h.replace("ses^","ses:"),d=d+h;h=e.attr("pos");d+=h?"@pos:"+h:"";if("9224"==b.cate1||"13941"==b.cate1)h=e.attr("_pos"),e=e.attr("sortid"),d=d+(h?"@npos:"+h:"")+(e?"@sortid:"+e:"");""!=d&&(0===d.indexOf("@")&&(d=d.substring(1)),g.push(d));d=g.join("_");"NO"==a.filterList(b.curURL)&&-1!=b.curURL.indexOf(".58.com")&&(e=$(this).attr("href")||"#",-1!=e.indexOf("javascript:")||"#"==
e.substring(0,1)||"NO"!=a.filterList(e)||"/"!=e.substring(0,1)&&-1==e.indexOf(".58.com")||e.match(/[\?&]iuType=/)||$(this).attr("href",e.trim()+(-1==e.indexOf("?")?"?":"&")+"iuType="+c[0]+"_"+c[1]));a.sendLog("listClickLog",{tag:"mlistclick",info_data:d,rand_id:f.getRandom()});setTimeout("GCIDPlus()",300)}}},d=$("[tongji_label=listclick]");d&&0<d.length?f.bindElem("[logr] [tongji_label=listclick]","click",function(){c($(this))}):f.bindElem("li[logr] a","click",function(){var a=$(this).attr("class");
"function"==typeof $(this).parents&&"diyu_sale"!=a&&"company_job"!=a&&c($(this))})}},oldListClickLog:function(a){this.sendLog("oldListClickLog",{tag:"mlistclick",bi_val_pos:a.replace("&bi_val_pos=",""),rand:f.getRandom()});setTimeout("GCIDPlus()",300)},listShowLog:function(){var a=this.baseInfo,b=a.cate1,c=[];if(e.$&&"list"===a.pagetype&&"function"==typeof $("li[logr]").attr){for(var d=$("li[logr]"),q=d.length,g=a.curPageNum,n=a.curIndex;n<q;n++){var l=$(d[n]),h=l.attr("logr"),m=l.attr("pagenum");
if(1===g||g===m)if(h){var h=[],k=l.attr("logr").split("_"),m="";h.push(k[0],k[1],k[2],k[3]);4<k.length&&(k=k[k.length-1],k=k.replace("ses^","ses:"),m+=k);k=l.attr("pos");m+=k?"@pos:"+k:"";if("9224"===b||"13941"===b)k=l.attr("_pos"),l=l.attr("sortid"),m+=k?"@npos:"+k:"",m+=l?"@sortid:"+l:"";""!=m&&(0===m.indexOf("@")&&(m=m.substring(1)),h.push(m));c.push(h.join("_"))}else h=l.attr("post_type"),m=l.attr("enum_user"),k=l.attr("uid"),l=l.attr("infoid"),h=h+"_"+m+"_"+k+"_"+l,l&&"function"===typeof $("[infoid]").index&&
(k=$("[infoid]").index($(this))+1,h+="_@pos:"+k),c.push(h);else break}a.curIndex=n;this.sendLog("listShowLog",{tag:"mlistshow",info_data:c.join(","),rand_id:f.getRandom()})}},bindTongji_tag:function(){if(e.$){var a=this;f.bindElem("[tongji_tag]","click",function(){var b=$(this).attr("tongji_tag"),c=$(this).text().trim();a.clickLog("from="+b+"&text="+encodeURIComponent(c)+"&tongji_type=tongji_tag")})}},bindTongji_id:function(){if(e.$){var a=this;f.bindElem("[tongji_id]","click",function(b){var c=b.srcElement?
b.srcElement:b.target;"A"==c.tagName.toUpperCase()&&(b=$(c).attr("href")||"#",c=$(c).text(),-1==b.indexOf("javascript:")&&"#"!=b.substring(0,1)&&a.clickLog("from="+$(this).attr("tongji_id")+"&text="+encodeURIComponent(c)+"&to="+encodeURIComponent(b)+"&tongji_type=tongji_id"))})}},diaShowLog:function(a){},loadMorePageLog:function(a){var b=this.baseInfo;if(a&&-1!=a.indexOf("pagenum=")){var c=a.split("=",-1)[1];b.trackURL=b.trackURL.replace(/'pagenum':[^,}&]*/,"'pagenum':'"+c+"'");b.curPageNum=c}this.sendLog("loadMorePageLog",
{tag:"pvstatall",EventTag:"loadMorePage&"+a,rand_id:f.getRandom()});this.listShowLog()},bindAlsTag:function(){if(!f.getCookie("als")&&e.$&&"function"===typeof $("body").one)$("body").one("mouseover",function(){f.setCookie("als","0",365)});f.getCookie("isSpider")&&f.setCookie("isSpider","",0)},bindHomeHeatMap:function(){var a=this.baseInfo;if(e.$&&"home"===a.pagetype&&"m_zhuzhan"===a.actiontype)for(var b=$("[tongji_tag]"),c=0;c<b.length;c++){var f=b[c],d=$(f).attr("href")||"#",g=$(f).attr("tongji_tag")||
"NA";-1==d.indexOf("javascript:")&&"#"!=d.substring(0,1)&&(d=d.match(/[\?&]58hm=[^&]*/)?d.replace(/58hm=[^&]*/,"58hm="+g):d.trim()+(-1==d.indexOf("?")?"?":"&")+"58hm="+g,d=d.match(/[\?&]58cid=[^&]*/)?d.replace(/58cid=[^&]*/,"58cid="+a.area1):d.trim()+(-1==d.indexOf("?")?"?":"&")+"58cid="+a.area1,$(f).attr("href",d))}},bindIndexHeatMap:function(){var a=this.baseInfo;if(e.$&&"index"===a.pagetype&&"m_zhuzhan"===a.actiontype&&"YES"==this.isRealIndexPage(a.curURL))for(var b=$("[tongji_tag]"),c=0;c<b.length;c++){var f=
b[c],d=$(f).attr("href")||"#",g=$(f).attr("tongji_tag")||"NA";-1==d.indexOf("javascript:")&&"#"!=d.substring(0,1)&&(d=d.match(/[\?&]58ihm=[^&]*/)?d.replace(/58ihm=[^&]*/,"58ihm="+g):d.trim()+(-1==d.indexOf("?")?"?":"&")+"58ihm="+g,d=d.match(/[\?&]58cid=[^&]*/)?d.replace(/58cid=[^&]*/,"58cid="+a.area1):d.trim()+(-1==d.indexOf("?")?"?":"&")+"58cid="+a.area1,$(f).attr("href",d))}},bindAddGTIDtoURL:function(){var a=this,b=this.baseInfo;e.$&&f.bindElem("a","click",function(){if("NO"==a.filterList(b.curURL)&&
-1!=b.curURL.indexOf(".58.com")){var c=$(this).attr("href")||"#";-1!=c.indexOf("javascript:")||"#"==c.substring(0,1)||"NO"!=a.filterList(c)||"/"!=c.substring(0,1)&&-1==c.indexOf(".58.com")||(c.match(/[\?&]ClickID=\d*/)?$(this).attr("href",c.replace(/ClickID=\d*/,"ClickID="+b.ClickID)):$(this).attr("href",c.trim()+(-1==c.indexOf("?")?"?":"&")+"PGTID="+b.GTID+"&ClickID="+b.ClickID))}})},insertMiGuan:function(){try{var a="default";switch(this.baseInfo.cate1){case "9224":case "9225":case "13941":case "13952":a=
"yewu";break;case "1":a="ershoufang";break;case "5":a="shouji";break;case "832":a="dog";break;case "4":a="ershouche";break;default:a="shenghuo"}var b=Math.ceil(1E14*Math.random()),c=document.getElementsByTagName("body")[0],d=document.createElement("div");d.id="addInfo";d.style.display="none";var e=document.createElement("a");e.href=f.protocol+"//tracklog.58.com/detail/m/"+a+"/"+b+"x.shtml";e.text="\u63a8\u8350\u4fe1\u606f";d.appendChild(e);c.appendChild(d)}catch(g){}},bindUndefinedClickLog:function(){if(e.limited_show){var a=
limited_show.replace(/\[/g,"").replace(/\]/g,"").trim().split(","),b;for(b in a)a[b].trim()&&this.clickLog(a[b].trim())}if(e._statisArr)for(a=e._statisArr;a instanceof Array&&0<a.length;)b=a.shift(),b instanceof Array?this.clickLog("from="+b[0]+"&sumval="+b[1]):this.clickLog(b)},DMloadByTag:function(){try{var a=this.getValByUrl(f.curURL,"dm-statistic-detect"),b=f.getCookie("dm-statistic-detect");if(a=("NA"==a?"":a)||b||"")switch(e.TJ58ecdata={},e.TJ58ecdata.platform="58M",a){case "2":f.loadScript("http://bigdata.web.58dns.org/stat/static/js/referrer_alert.js");
break;case "3":f.loadScript("http://bigdata.web.58dns.org/stat/static/js/referrer_visual.js")}}catch(c){}}};d.baseInfo=d.getBaseInfo();d.trackLog();d.listShowLog();d.listClickLog();d.bindAlsTag();d.bindTongji_tag();d.bindTongji_id();d.bindHomeHeatMap();d.bindIndexHeatMap();d.bindAddGTIDtoURL();d.bindUndefinedClickLog();d.insertMiGuan();e.clickLog=function(a){d.clickLog(a)};e.showLog=function(a){};e.loadMorePage=function(a){d.loadMorePageLog(a)};e.ajaxlog_mlistshow=function(){d.listShowLog()};e.GCIDPlus=
function(){d.baseInfo.ClickIDPlus()};e.listClickLog=function(a){};e.reTrackLog=function(){d.baseInfo=d.getBaseInfo();d.trackLog();d.listShowLog()};e.getGTID=function(){return d.baseInfo.GTID};e._gaq=e._gaq||[];d.DMloadByTag()}})(window);
