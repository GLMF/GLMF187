import pyautogui
import time

def detect_state(unit, dico):
    for state in ('_ready', '_wait'):
        dico[unit + state] = pyautogui.locateOnScreen('images/' + unit + state + '.png')

def clickAndForget(x=10, y=10):
    pyautogui.click()
    pyautogui.moveTo(x, y)

if __name__ == '__main__':
    region = {}
    units = ('tanneur', 'chevrier_1', 'chevrier_2', 'forgeron', 'fruitier')
    prod = { 'tanneur' : 'peau de chèvre', 'chevrier_1' : '1/6 fromage',
             'chevrier_2' : '1/6 fromage', 'forgeron' : 'fer à cheval',
             'fruitier' : 'choux'
           }

    while True:
        for unit in units:
            detect_state(unit, region)

        for key in region:
            if region[key] is not None:
                pyautogui.moveTo(pyautogui.center(region[key]))
                pyautogui.moveRel(None, 10)
                clickAndForget()
                region[key] = None
                if key.endswith('_ready'):
                    unit = key.split('_ready')[0]
                    print('[{} / {}] Récupération ressources'.format(time.strftime('%H:%M:%S'),
                                                                     unit))
                elif key.endswith('_wait'):
                    unit = key.split('_wait')[0]
                    print('[{} / {}] Ordre de fabrication'.format(time.strftime('%H:%M:%S'),
                                                                  unit))
                    region_2 = None
                    while region_2 is None:
                        unitType = unit.split('_')[0]
                        region_2 = pyautogui.locateOnScreen('images/' + unitType +'_prod.png')
                        if region_2 is not None:
                            print('[{} / {}] Fabrication {}'.format(time.strftime('%H:%M:%S'),
                                                                    unit, prod[unit]))
                            pyautogui.moveTo(pyautogui.center(region_2))
                            clickAndForget()
