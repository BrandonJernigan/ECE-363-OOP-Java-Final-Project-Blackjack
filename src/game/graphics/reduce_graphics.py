# -*- coding: utf-8 -*-
"""
Spyder Editor

This is a temporary script file.
"""

import os
from PIL import Image

size = 500, 500
root = os.getcwd()
for path, subdirs, files in os.walk(root):
    for name in files:
        if name == "reduce_graphics.py" or name == "icon.ico":
            continue
        full_path = os.path.join(path, name)
        image = Image.open(full_path)
        
        rgb_im = image.convert('RGB')
        
        new_path = os.path.join(path, "%s.jpg" % name.split('.')[0])
        rgb_im.save(new_path,quality=50,optimize=True)
        os.remove(full_path)
