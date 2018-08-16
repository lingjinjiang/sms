$(document).ready(function(){
  getData();
})

function getData(){
  var data = {"d":"[ {\"userInfo\": [{ \"name\" : \"王康羽\" , \"id\" : \"0000001308\" ,\"patientName\" : \"王康羽\" ,\"patientNo\" : \"508129\" ,\"label\" : \"全血\" ,\"sex\" : \"男\" ,\"deptName\" : \"儿科门诊\" ,\"chekDate\" : \"2016/11/22 0:00:00\" ,\"age\" : \"3\" ,\"bedNo\" : \"\" ,\"doctor\" : \"解莹晶\" ,\"getLabelDate\" : \"2016/11/22 0:00:00\" ,\"reportDate\" : \"2016/11/22 0:00:00\" ,\"trier\" : \"杜仁燕\" ,\"assurance\" : \"杜仁燕\", \"mobile\" : \"\" }]}, {\"lisDetial\": [{ \"type\" : \"儿童血常规\" , \"name\" : \"白细胞\" ,\"result\" : \"12.94\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"↑\" ,\"range\" : \"3.5-9.5\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"淋巴细胞百分比\" ,\"result\" : \"12\" ,\"unit\" : \"%\" ,\"flag\" : \"↓\" ,\"range\" : \"20-40\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"单核细胞百分比\" ,\"result\" : \"6.7\" ,\"unit\" : \"%\" ,\"flag\" : \"\" ,\"range\" : \"3-8\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"中性粒细胞百分比\" ,\"result\" : \"81\" ,\"unit\" : \"%\" ,\"flag\" : \"↑\" ,\"range\" : \"50-70\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"淋巴细胞绝对值\" ,\"result\" : \"1.55\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"\" ,\"range\" : \"0.4-4.4\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"单核细胞绝对值\" ,\"result\" : \"0.87\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"↑\" ,\"range\" : \"0-0.8\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"中性粒细胞绝对值\" ,\"result\" : \"10.48\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"↑\" ,\"range\" : \"1.7-7.7\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"红细胞\" ,\"result\" : \"4.6\" ,\"unit\" : \"10^12/L\" ,\"flag\" : \"\" ,\"range\" : \"3.5-5.5\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"血红蛋白\" ,\"result\" : \"128\" ,\"unit\" : \"g/L\" ,\"flag\" : \"\" ,\"range\" : \"110-170\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"红细胞压积\" ,\"result\" : \"37.1\" ,\"unit\" : \"\" ,\"flag\" : \"\" ,\"range\" : \"37-49\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"平均红细胞体积\" ,\"result\" : \"81.4\" ,\"unit\" : \"fL\" ,\"flag\" : \"\" ,\"range\" : \"75-100\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"平均红细胞血红蛋白量\" ,\"result\" : \"28.1\" ,\"unit\" : \"pg\" ,\"flag\" : \"\" ,\"range\" : \"25-34\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"平均红细胞血红蛋白浓度\" ,\"result\" : \"345\" ,\"unit\" : \"g/L\" ,\"flag\" : \"\" ,\"range\" : \"290-360\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"红细胞分布宽度（CV）\" ,\"result\" : \"13.1\" ,\"unit\" : \"%\" ,\"flag\" : \"\" ,\"range\" : \"10-26.5\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"血小板计数\" ,\"result\" : \"235\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"\" ,\"range\" : \"100-300\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"血小板平均体积\" ,\"result\" : \"9.4\" ,\"unit\" : \"fL\" ,\"flag\" : \"\" ,\"range\" : \"9.1-13.5\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"血小板分布宽度\" ,\"result\" : \"10.6\" ,\"unit\" : \"fL\" ,\"flag\" : \"\" ,\"range\" : \"9-18.1\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"嗜酸细胞百分比\" ,\"result\" : \"0.2\" ,\"unit\" : \"%\" ,\"flag\" : \"↓\" ,\"range\" : \"0.5-5\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"嗜碱细胞百分比\" ,\"result\" : \"0.1\" ,\"unit\" : \"%\" ,\"flag\" : \"\" ,\"range\" : \"0-1\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"嗜酸细胞绝对值\" ,\"result\" : \"0\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"\" ,\"range\" : \"0-0.3\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"嗜碱细胞绝对值\" ,\"result\" : \"0.1\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"\" ,\"range\" : \"0-0.2\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"红细胞分布宽度（SD）\" ,\"result\" : \"37.7\" ,\"unit\" : \"fL\" ,\"flag\" : \"↓\" ,\"range\" : \"39-54\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"血小板比积\" ,\"result\" : \"0.22\" ,\"unit\" : \"\" ,\"flag\" : \"\" ,\"range\" : \"0.17-0.39\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"C-反应蛋白\" ,\"result\" : \"4.4\" ,\"unit\" : \"mg/L\" ,\"flag\" : \"\" ,\"range\" : \"0-10\" }]}]"};
  let reportList = data.d
  dealData(JSON.parse(reportList));
}

function dealData(back_data){
  let str = '';
  back_data['lisInfo'].forEach(( ab, i ) => {
    let date = ab['checkDate'].split(' ');
    let replace_date = String(date[0]).replace(/\//g,'-');
    let replace_date_array = replace_date.split('-');
    let month = replace_date_array[1]['length']==2?replace_date_array[1]:('0'+replace_date_array[1]);
    let day = replace_date_array[2]['length']==2?replace_date_array[2]:('0'+replace_date_array[2]);
    let now_date = replace_date_array[0]+'-'+month+'-'+day;
	let url_str = './show.html?clinicCode='+ab['clinicCode']+'&type='+ab['type']+'&item='+ab['item'];
    if (i % 2) {
      reportColor="#38afdc";    
    } else {
      reportColor="#ff9800";
    }
    str += '<div class="report">';
    str += '  <a href="'+url_str+'">'
    str += '    <div class="report-title" style="background: ' + reportColor + '">';
    str += '      检验报告';
    str += '    </div>';
    str += '    <div class="report-info">';
    str += '      <div style="font-size: 25px; margin-right: 10px; padding-top: 10px;">';
    str +=          ab['type'];
    str += '      </div>';
    str += '      <hr class="split"/>';
    str += '      <div style="font-size: 15px; margin-right: 10px;">';
    str +=          now_date;
    str += '      </div>';
    str += '    </div>';
    str += '  </a>'
    str += '</div>';
    str += '<hr style="margin: 3px; visibility: hidden;"/>';
  });
  $.hideLoading();
  $('#container').html(str);
}