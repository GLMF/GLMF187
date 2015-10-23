function start()
{
  var info = document.getElementById('info');
  var fingerName = ['pouce', 'index', 'majeur', 'annulaire', 'auriculaire'];
  var i, finger;

  Leap.loop(function(frame)
    {
      if ((frame.hands.length == 1) && (frame.hands[0].type == 'right'))
      {
        info.innerHTML = '';
        for (i = 0; i < 5; i++)
        {
          finger = frame.hands[0].fingers[i];
          if (finger.extended)
          {
            info.innerHTML += ' ' + fingerName[i];
          }
        }
      }
      else
      {
        info.innerHTML = 'aucun';
      }
    }
  );
};
