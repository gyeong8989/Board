<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8"/>
	<title>Kakao 지도 시작하기</title>
</head>

<!-- 현재 위치 위도 경도 찾기 -->
<script>
	var latitude;
	var longitude;
	navigator.geolocation.getCurrentPosition(function(pos){
		
		latitude = pos.coords.latitude;
		longitude = pos.coords.longitude;
		//alert("현 위 경 도 : " + latitude + "," + longitude); 
	})
	
		
</script>

<body>
	<div id="map" style="width:500px;height:400px;"></div>
	<script type="text/javascript" src="//dapi.kakao.com/v2/maps/sdk.js?appkey=562e30019b0739681ec6d4f9c72d969a"></script>
	<script>
		var container = document.getElementById('map');
		var options = {
			center: new kakao.maps.LatLng(latitude, longitude),
			level: 3
		};

		var map = new kakao.maps.Map(container, options);
	</script>
</body>
</html>