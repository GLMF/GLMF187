function start()
{
  var info = document.getElementById('info');
  var gestureName = { 'circle' : 'cercle', 'swipe' : 'glissement',
    'keyTap' : 'appui sur touche', 'screenTap' : 'appui sur écran' }

  Leap.loop({enableGestures: true}, function (frame)
    {
      if (frame.valid && frame.gestures.length > 0)
      {
        frame.gestures.forEach(function (gesture)
          {
            info.innerHTML = gestureName[gesture.type];
          }
        );
      }
    }
  );
};
