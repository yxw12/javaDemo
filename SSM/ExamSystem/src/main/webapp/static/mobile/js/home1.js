var nav={aa:function(){$(".jk_menu li").click(function(e){var index=$(this).attr("index");for(var i=0;i<$(".jk_box").length;i++){$(this).parent().children().eq(i).removeClass("on");$(".jk_box").eq(i).hide()}$(this).addClass("on");$(".jk_box").eq(index).show();if($(".jk_box").eq(index).hasClass("zgz")){$(".km2").hide();$(".km3").hide();$(".kstv").hide()}else{$(".km2").show();$(".km3").show();$(".kstv").show()}})}};$(function(){nav.aa()});