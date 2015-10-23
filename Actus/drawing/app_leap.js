function createPointer()
{
  var pointer = document.createElement('div');
  pointer.id = 'leap';
  pointer.style.position = 'absolute';
  pointer.style.visibility = 'hidden';
  pointer.style.zIndex = 50;
  pointer.style.opacity = 0.7;
  pointer.style.backgroundColor = '#f00';
  pointer.style.width = '15px';
  pointer.style.height = '15px';
  pointer.style.borderRadius = '10px';
  document.body.appendChild(pointer);
  return pointer;
};

function start()
{
  var i, displayPointer, tipPosition, entered, enteredPosition;
  var pointer = createPointer(); 

  Leap.loop(function(frame)
    {
      if ((frame.hands.length == 1) && (frame.hands[0].type == 'right'))
      {
        displayPointer = 0;
        for (i = 0; i < 5; i++)
        {
          if (frame.hands[0].fingers[i].extended)
          {
            displayPointer++;
          }
        }
        if ((frame.hands[0].fingers[1].extended) && (displayPointer == 1))
        {
          pointer.style.visibility = 'visible';
          tipPosition = frame.hands[0].fingers[1].tipPosition;
       
          if (!entered) 
          {
            entered = true;
            enteredPosition = frame.hands[0].fingers[1].tipPosition;
          }
          
          pointer.style.top =
            (-1 * ((tipPosition[1] - enteredPosition[1]) * 
                   document.body.offsetHeight / 120)) +
            (document.body.offsetHeight / 2 ) + 'px';

          pointer.style.left =
            ((tipPosition[0] - enteredPosition[0]) * document.body.offsetWidth / 120) +
            (document.body.offsetWidth / 2) + 'px';
        }
        else
        {
          pointer.style.visibility = 'hidden';
        }
      }
    }
  );
};
