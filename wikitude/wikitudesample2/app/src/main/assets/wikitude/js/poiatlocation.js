// implementation of AR-Experience (aka "World")
//Worldにロジックを記述する。
var World = {
	// true once data was fetched
	initiallyLoadedData: false,
	initiallyLoadedDataSecond: false,

	// POI-Marker asset。マーカーの画像
	markerDrawable_idle: null,
	markerDrawable_second: null,

	// called to inject new POI data。
	// マーカーを設置する。
	loadPoisFromJsonData: function loadPoisFromJsonDataFn(poiData) {

		/*
			The example Image Recognition already explained how images are loaded and displayed in the augmented reality view. This sample loads an AR.ImageResource when the World variable was defined. It will be reused for each marker that we will create afterwards.
		*/
		//画像
		World.markerDrawable_idle = new AR.ImageResource("assets/kirin_popup.png");

		/*
			For creating the marker a new object AR.GeoObject will be created at the specified geolocation. An AR.GeoObject connects one or more AR.GeoLocations with multiple AR.Drawables. The AR.Drawables can be defined for multiple targets. A target can be the camera, the radar or a direction indicator. Both the radar and direction indicators will be covered in more detail in later examples.
		*/
		//位置情報
		var markerLocation = new AR.GeoLocation(poiData.latitude, poiData.longitude, poiData.altitude);
		//描画情報.８は８倍のサイズ
		var markerImageDrawable_idle = new AR.ImageDrawable(World.markerDrawable_idle, 8, {
			zOrder: 0,//表示順
			opacity: 1.0,//不透明
			//クリック時処理
			onClick : function() {
				//アニメーション開始
      			//elevatorAnimation.start();
      			//リンクへ飛ぶ
      			window.open("http://www.noichizoo.or.jp/park/animal_intro04_giraffe.html");
      			//window.open("../../../res/sub.xml");
    		}
    	});

		// create GeoObject
		//AR上に配置
		var markerObject = new AR.GeoObject(markerLocation, {
			drawables: {
				cam: [markerImageDrawable_idle]
			}
		});

		// Updates status message as a user feedback that everything was loaded properly.
		//メッセージ
		World.updateStatusMessage('Load completed');
		//World.updateStatusMessage("緯度・経度・高度：" + latitude + ", " + longitude + ", " + altitude);
	},

	loadPoisFromJsonDataSecond: function loadPoisFromJsonDataFn(poiData2) {

        /*
            The example Image Recognition already explained how images are loaded and displayed in the augmented reality view. This sample loads an AR.ImageResource when the World variable was defined. It will be reused for each marker that we will create afterwards.
        */
        //画像
        World.markerDrawable_second = new AR.ImageResource("assets/haiena_popup.png");

        /*
            For creating the marker a new object AR.GeoObject will be created at the specified geolocation. An AR.GeoObject connects one or more AR.GeoLocations with multiple AR.Drawables. The AR.Drawables can be defined for multiple targets. A target can be the camera, the radar or a direction indicator. Both the radar and direction indicators will be covered in more detail in later examples.
        */
        //位置情報
        var markerLocationSecond = new AR.GeoLocation(poiData2.latitude, poiData2.longitude, poiData2.altitude);
        //描画情報.８は８倍のサイズ


        var markerImageDrawable_second = new AR.ImageDrawable(World.markerDrawable_second, 8, {
            zOrder: 0,//表示順
            opacity: 1.0,//不透明
            //クリック時処理
            onClick : function() {
                //アニメーション開始
                //elevatorAnimation.start();
                //リンクへ飛ぶ
                widow.open("http://www.noichizoo.or.jp/park/animal_intro04_hyena.html");
            }
        });

//        var elevatorAnimation = new AR.PropertyAnimation(
//            markerImageDrawable_idle, //the object geoLocation1 holds the animated property
//            "rotation", //the property altitude will be animated
//            0, //the start value of the animation
//            360, //the resulting value of the animation
//            1000, //the duration of the elevator climb is 10 seconds (10000 miliseconds)
//            {type: AR.CONST.EASING_CURVE_TYPE.EASE_IN_OUT_QUAD}
//
//        );

        // create GeoObject
        //AR上に配置

        var markerObjectSecond = new AR.GeoObject(markerLocationSecond, {
            drawables: {
                cam: [markerImageDrawable_second]
            }
        });

        // Updates status message as a user feedback that everything was loaded properly.
        //メッセージ
        world.updateStatusMessage("Load completed")
        //World.updateStatusMessage("緯度・経度・高度・精度：" + lat + ", " + lon + ", " + alt + ", " + acc);
    },

	// updates status message shon in small "i"-button aligned bottom center
	//inde.htmlのメッセージやアイコンに状態を表示する
	updateStatusMessage: function updateStatusMessageFn(message, isWarning) {

		var themeToUse = isWarning ? "e" : "c";
		var iconToUse = isWarning ? "alert" : "info";

		$("#status-message").html(message);
		$("#popupInfoButton").buttonMarkup({
			theme: themeToUse
		});
		$("#popupInfoButton").buttonMarkup({
			icon: iconToUse
		});
	},

	//位置が変化した時の処理。メインルーチンみたいになる。
	// location updates, fired every time you call architectView.setLocation() in native environment
	locationChanged: function locationChangedFn(lat, lon, alt, acc) {

		/*
			The custom function World.onLocationChanged checks with the flag World.initiallyLoadedData if the function was already called. With the first call of World.onLocationChanged an object that contains geo information will be created which will be later used to create a marker using the World.loadPoisFromJsonData function.
		*/
		//最初だけマーカーの位置を作成する。
		if (!World.initiallyLoadedData) {
			// creates a poi object with a random location near the user's location
			var poiData = {
				"id": 1,
				//"longitude": (lon + (Math.random() / 5 - 0.1)),
				//"latitude": (lat + (Math.random() / 5 - 0.1)),
				"longitude": (133.719661), //経度
                "latitude": (33.620642), //緯度
				"altitude": 100.0 //標高
			};
			var poiData2 = {
                "id": 2,
                //"longitude": (lon + (Math.random() / 5 - 0.1)),
                //"latitude": (lat + (Math.random() / 5 - 0.1)),
                "longitude": (133.698337), //経度
                "latitude": (33.608232), //緯度
                "altitude": 100.0 //標高
            };
			//
			World.loadPoisFromJsonData(poiData);
			World.loadPoisFromJsonDataSecond(poiData2);
			//１回だけのフラグを立てる
			World.initiallyLoadedData = true;
		}
	},

};

/*
	Set a custom function where location changes are forwarded to. There is also a possibility to set AR.context.onLocationChanged to null. In this case the function will not be called anymore and no further location updates will be received.
*/
//位置情報が変化した時の処理。これがメインルーチンみたいになる。
AR.context.onLocationChanged = World.locationChanged;
AR.context.onLocationChangedSecond = World.locationChangedSecond;
AR.context.onScreenClick = World.onScreenClick;