<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@ page language="java" import="com.xtgj.j2ee.chapter02.entity.*" %>
<%@ page language="java" import="com.xtgj.j2ee.chapter02.user.biz.*" %>

<%
    Business bo = new Business();
    List cats = bo.findAllCategories();
%>
<html>
<head>
    <title>歌曲查找</title>
    <script type="text/javascript">
        var xmlHttp;

        //创建XMLHttpRequest对象的函数
        function createHttpRequest() {
            if (window.XMLHttpRequest) {
                xmlHttp = new XMLHttpRequest();
            } else if (window.ActiveXObject) {
                try {
                    xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
                } catch (e) {
                    try {
                        xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
                    } catch (e) {
                    }
                }
            }
        }

        //发送请求函数
        function sendRequest(catId) {
            if (catId == "") {
                clear();
                return;
            }
            createHttpRequest();
            xmlHttp.onreadystatechange = handleResponse;
            var url = "Search?catId=" + catId;
            xmlHttp.open("get", url, true);
            xmlHttp.send(null);
        }

        //处理响应函数
        function handleResponse() {
            if (xmlHttp.readyState == 4) {
                if (xmlHttp.status == 200) {
                    parseXML();
                } else {
                    alert("请求页面有异常");
                }
            }
        }

        //解析xml函数
        function parseXML() {
            clear();

            var xml = xmlHttp.responseXML;
            var songs = xml.getElementsByTagName("song");
            var tabResult = document.getElementById("results");

            for (var i = 0; i < songs.length; i++) {
                var name = songs[i].getElementsByTagName("name")[0]
                    .firstChild.data;
                var singer = songs[i].getElementsByTagName("singer")[0]
                    .firstChild.data;
                var album = songs[i].getElementsByTagName("album")[0]
                    .firstChild.data;
                var data = "歌名：" + name + "<br>歌手：" + singer
                    + "<br>专集：" + album + "<br>";
                var row = document.createElement("tr");
                var col = document.createElement("td");

                col.innerHTML = data;
                row.appendChild(col);
                tabResult.appendChild(row);
            }
        }

        //清空歌曲信息列表
        function clear() {
            var tabResult = document.getElementById("results");
            while (tabResult.childNodes.length > 0) {
                tabResult.removeChild(tabResult.firstChild);
            }
        }
    </script>
</head>

<body>
<h3>
    歌曲分类搜索
</h3>
<select onchange="sendRequest(this.value);">
    <option>
        请选择歌曲类别
    </option>
    <%
        for (int i = 0; i < cats.size(); i++) {
            Category cat = (Category) cats.get(i);
    %>
    <option value="<%=cat.getId()%>"><%=cat.getName()%>
    </option>
    <%
        }
    %>
</select>
<br>
<br>
<table cellpaddiing="3">
    <tbody id="results">
    </tbody>
</table>
</body>
</html>

