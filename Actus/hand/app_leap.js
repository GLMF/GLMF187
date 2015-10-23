function start()
{
  var info = document.getElementById('info');

  Leap.loop(function(frame)
    {
      var handType;

      if (frame.hands.length > 0)
      {
        handType = frame.hands[0].type;

        if (frame.hands.length == 2)
        {
          info.innerHTML = 'gauche et droite';
        }
        else if (handType == 'left')
        { 
          info.innerHTML = 'gauche';
        }
        else if (handType == 'right')
        {
          info.innerHTML = 'droite';
        }
      }
      else
      {
        info.innerHTML = 'aucune';
      }
    }
  );
};
