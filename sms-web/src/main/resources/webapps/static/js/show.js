$(document).ready(function(){
  render();
})


// curl -X POST -H "Content-Type: application/json" http://218.2.176.62:8099/WebService.asmx/GetLisDetial -d "{\"clinicCode\": \"508129\", \"type\": \"儿童血常规\"}"

function render() {
  var data = {"d":"[ {\"userInfo\": [{ \"name\" : \"王康羽\" , \"id\" : \"0000001308\" ,\"patientName\" : \"王康羽\" ,\"patientNo\" : \"508129\" ,\"label\" : \"全血\" ,\"sex\" : \"男\" ,\"deptName\" : \"儿科门诊\" ,\"chekDate\" : \"2016/11/22 0:00:00\" ,\"age\" : \"3\" ,\"bedNo\" : \"\" ,\"doctor\" : \"解莹晶\" ,\"getLabelDate\" : \"2016/11/22 0:00:00\" ,\"reportDate\" : \"2016/11/22 0:00:00\" ,\"trier\" : \"杜仁燕\" ,\"assurance\" : \"杜仁燕\", \"mobile\" : \"\" }]}, {\"lisDetial\": [{ \"type\" : \"儿童血常规\" , \"name\" : \"白细胞\" ,\"result\" : \"12.94\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"↑\" ,\"range\" : \"3.5-9.5\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"淋巴细胞百分比\" ,\"result\" : \"12\" ,\"unit\" : \"%\" ,\"flag\" : \"↓\" ,\"range\" : \"20-40\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"单核细胞百分比\" ,\"result\" : \"6.7\" ,\"unit\" : \"%\" ,\"flag\" : \"\" ,\"range\" : \"3-8\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"中性粒细胞百分比\" ,\"result\" : \"81\" ,\"unit\" : \"%\" ,\"flag\" : \"↑\" ,\"range\" : \"50-70\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"淋巴细胞绝对值\" ,\"result\" : \"1.55\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"\" ,\"range\" : \"0.4-4.4\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"单核细胞绝对值\" ,\"result\" : \"0.87\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"↑\" ,\"range\" : \"0-0.8\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"中性粒细胞绝对值\" ,\"result\" : \"10.48\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"↑\" ,\"range\" : \"1.7-7.7\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"红细胞\" ,\"result\" : \"4.6\" ,\"unit\" : \"10^12/L\" ,\"flag\" : \"\" ,\"range\" : \"3.5-5.5\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"血红蛋白\" ,\"result\" : \"128\" ,\"unit\" : \"g/L\" ,\"flag\" : \"\" ,\"range\" : \"110-170\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"红细胞压积\" ,\"result\" : \"37.1\" ,\"unit\" : \"\" ,\"flag\" : \"\" ,\"range\" : \"37-49\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"平均红细胞体积\" ,\"result\" : \"81.4\" ,\"unit\" : \"fL\" ,\"flag\" : \"\" ,\"range\" : \"75-100\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"平均红细胞血红蛋白量\" ,\"result\" : \"28.1\" ,\"unit\" : \"pg\" ,\"flag\" : \"\" ,\"range\" : \"25-34\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"平均红细胞血红蛋白浓度\" ,\"result\" : \"345\" ,\"unit\" : \"g/L\" ,\"flag\" : \"\" ,\"range\" : \"290-360\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"红细胞分布宽度（CV）\" ,\"result\" : \"13.1\" ,\"unit\" : \"%\" ,\"flag\" : \"\" ,\"range\" : \"10-26.5\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"血小板计数\" ,\"result\" : \"235\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"\" ,\"range\" : \"100-300\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"血小板平均体积\" ,\"result\" : \"9.4\" ,\"unit\" : \"fL\" ,\"flag\" : \"\" ,\"range\" : \"9.1-13.5\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"血小板分布宽度\" ,\"result\" : \"10.6\" ,\"unit\" : \"fL\" ,\"flag\" : \"\" ,\"range\" : \"9-18.1\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"嗜酸细胞百分比\" ,\"result\" : \"0.2\" ,\"unit\" : \"%\" ,\"flag\" : \"↓\" ,\"range\" : \"0.5-5\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"嗜碱细胞百分比\" ,\"result\" : \"0.1\" ,\"unit\" : \"%\" ,\"flag\" : \"\" ,\"range\" : \"0-1\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"嗜酸细胞绝对值\" ,\"result\" : \"0\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"\" ,\"range\" : \"0-0.3\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"嗜碱细胞绝对值\" ,\"result\" : \"0.1\" ,\"unit\" : \"10^9/L\" ,\"flag\" : \"\" ,\"range\" : \"0-0.2\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"红细胞分布宽度（SD）\" ,\"result\" : \"37.7\" ,\"unit\" : \"fL\" ,\"flag\" : \"↓\" ,\"range\" : \"39-54\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"血小板比积\" ,\"result\" : \"0.22\" ,\"unit\" : \"\" ,\"flag\" : \"\" ,\"range\" : \"0.17-0.39\" },{ \"type\" : \"儿童血常规\" , \"name\" : \"C-反应蛋白\" ,\"result\" : \"4.4\" ,\"unit\" : \"mg/L\" ,\"flag\" : \"\" ,\"range\" : \"0-10\" }]}]"};
  let back_string = data.d;
  let back = JSON.parse(back_string.replace(/\n/g,""));
  renderUserInfo(back[0]['userInfo'][0]);
  renderDetail(back[1]['lisDetial'], '检验');

  // let search = getUrlParam();
  // $.showLoading();
  // let send_data = {
  //   'clinicCode':search['clinicCode'],
  //   'type':search['type']
  // }

  // let item = search['item'];
  // $.ajax({
  //   type:'post',
  //   url:'http://127.0.0.1:8080/report/detail',
  //   // url:'http://218.2.176.62:8099/WebService.asmx/GetLisDetial',
  //   contentType:'application/x-www-form-urlencoded',
  //   data:JSON.stringify(send_data),
  //   // dataType:'xml',
  //   dataType:'json',
  //   success:function( data){
  //     // let back_string = $(data).find('string')[0]['innerHTML'];
  //     let back_string = data.d;
  //     let back = JSON.parse(back_string.replace(/\n/g,""));
  //     renderUserInfo(back[0]['userInfo'][0]);
  //     if(item=='检验'){
  //       renderDetail(back[1]['lisDetial'], item);
  //     }else{
  //       let back_data = JSON.parse(back_string.replace(/\n/g,""));
  //       renderDetail(back_data[1]['pacsDetial'][0], item);
  //     }
      
  //     $.hideLoading();
  //   }
  // })
}

function renderUserInfo( peer) {
  $('#name').html(peer['name']);
  $('#deptName').html(peer['deptName']);
  if (peer['chekDate'] != null && peer['chekDate'] != "undefined" && peer['chekDate'] != "") {
    $('#chekDate').html(peer['chekDate'].split(' ')[0]);
  }
  $('#label').html(peer['label']);
  $('#patientNo').html(peer['patientNo']);
  $('#age').html(peer['age']);
  $('#gender').html(peer['sex']);
  $('#doctor').html(peer['doctor']);
}

function renderDetail( details, item) {
  let reg = new RegExp(".*-.*");
  if(item == '检验'){
    let content = '';
    details.forEach(( detail, i ) => {
      if (detail['range'] != null && detail['range'] != "undefined" && detail['range'] != "" && reg.test(detail['range'])) {
        
        let name = detail['name'];
        let unit = detail['unit'];
        // if (detail['unit'] != null && detail['unit'] != "undefined" && detail['unit'] != "") {
        //   name += ' (' + detail['unit'] + ')';
        // }
        let flag = detail['flag'];
        let result = detail['result'];
        if (flag == '↑' || flag == '↓') {
          result = 'style="color: #FF0000;">' + flag + ' ' + result;
        } else {
          result = 'style="color: #00AA00;">' + result;
        }
        let range = detail['range'];

        content += '<div class="detail">';
        content += '<table>';
        content += '<tr>';
        content += '<td class="bottom-dashed">' + '<span class="result">' + name + '</span>' +'</td>';
        content += '<td class="right-td bottom-dashed">' + '<span class="result"' + result + '</span>' + '</td>';
        content += '</tr>';
        content += '<tr>';
        content += '<td>' + '<span>单位: ' + unit + '</span></td>';
        content += '<td class="right-td">' + '<span>参考值: ' + range +'</span></td>';
        content += '</tr>';
        content += '</table>';
        content += '</div>';
      } else {
        content += '<div id="detail-' + i + '" class="detail">';
        content += '  <table>';
        content += '    <tbody>';
        content += '      <tr>';
        content += '        <td><span id="name-' + i + '" class="detail-name">' + detail['name'] + '</span></td>';
        content += '        <td><span id="result-' + i + '" class="detail-name">' + detail['unit'] + '</span></td>';
        content += '      </tr>';
        content += '    </tbody>';
        content += '  </table>';
        content += '</div>';
      }
    });
    $('#detail').html(content);
  } else {
    $('#chekDate').html(details['reportDate'].split(' ')[0]);
    $('#doctor').html(details['trier']);
    $('#label').html(details['type']);

    let content = '';

    content += '<div id="detail" class="other-detail">';
    content += '  <p class="other-name">检查描述</p>';
    content += '  <hr class="detail-hr"/>';
    content += '    <p id="script" class="small_detail"></p>';
    content += '</div>';
    content += '<div id="detail" class="other-detail">';
    content += '  <p class="other-name">检查结论</p>';
    content += '  <hr class="detail-hr"/>';
    content += '    <p id="result" class="small_detail"></p>';
    content += '</div>';


    $('#detail').html(content);
    $('#script').html(details['script']);
    $('#result').html(details['result'])
  }
}