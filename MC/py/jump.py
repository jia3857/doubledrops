from mcpi import minecraft, block
import time

def jump(distance):
    #Let's wait 1 second
    time.sleep(1)

    #Retrieve the X,Y,Z coordinates of the player
    pos=mc.player.getPos()
    #Change the Y coordinate of the player to position it up in the sky
    mc.player.setPos(pos.x, pos.y + distance, pos.z)

#Main Program Starts Here:
jump(100)
