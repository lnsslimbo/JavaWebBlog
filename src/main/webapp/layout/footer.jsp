<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<hr>
<div id="footer">© 2020 Copyright:liunian</div>


<%--<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js"--%>
<%--	integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj"--%>
<%--	crossorigin="anonymous"></script>--%>
<%--<script src="https://cdn.jsdelivr.net/npm/bootstrap@4.5.3/dist/js/bootstrap.bundle.min.js"--%>
<%--	integrity="sha384-ho+j7jyWK8fNQe+A12Hb8AhRq26LrZ/JpcUGGOn+Y7RsweNrtN/tE3MoK7ZeZDyx"--%>
<%--	crossorigin="anonymous"></script>--%>

<script src="html/jquery.js"></script>
<script>
	$(function(){
		$("#picture").carousel({
			interval: 2000
		});

		$("#login").click(function(){
			hasError=false;
			if($("#name").val()==''){
				$("#nameError").html("用户名不能为空！");
				hasError=true;
			}
			else{
				$("#nameError").html("");
			}

			if(hasError){
				return false;
			}
		});

	});

</script>

<script src="https://cdn.bootcss.com/jquery/1.12.4/jquery.min.js"></script>
<script src="html/js/bootstrap.min.js"></script>