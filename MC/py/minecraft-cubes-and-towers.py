"""
  Make cubes and towers in Minecraft, with Python.
  
  Really fun way to introduce a kid to Python (or yourself to Minecraft, as I've learned).

  Setup instructions for Minecraft + macOS + Python: https://gist.github.com/noahcoad/fc9d3984a5d4d61648269c0a9477c622

  Additional setup:
    - Activate correct Java version: `export JAVA_HOME=`/usr/libexec/java_home -v 11.0.5``
    - Activate spigot `cd spigot; java -jar spigot.jar`
    - Open Minecraft, make installation of v13.0.1, go into Multiplayer, join server `localhost`, and then run this script

  API doc here for more functionality: https://www.stuffaboutcode.com/p/minecraft-api-reference.html
"""

import mcpi.minecraft as minecraft
import mcpi.block as block
import mcpi.entity as entity

# get game
mc = minecraft.Minecraft.create()

# get your current position and use to place objects
entityIds = mc.getPlayerEntityIds()
me = mc.entity.getPos(entityIds[0])
origin = (me.x, me.y, me.z)

# Make a solid cube of material
def cube(cubeSize, blockType, offsetXZ=5, offsetY=-5):
	if cubeSize <= 250:
		for x in range(0,cubeSize):
			for z in range(0,cubeSize):
				for y in range(0,cubeSize):
					mc.setBlock(origin[0]+x+offsetXZ, origin[1]+y+offsetY, origin[2]+z+offsetXZ, blockType)
	else:
		print("Sorry, that's too much! Making a lil' water cube instead.")
		cube(5, block.WATER.id)

# make cube() function create a big block of Lava. Also try: AIR, WATER, LAVA, and more!
# give offsetXZ of 15 so it's nearby but not on you. Try to offset to negative values so it's around you (be careful to not die)!
cube(10, block.LAVA.id,15)

## uncomment the line below to knock out (almost) everything around you and be in a big pit:
# cube(20, block.AIR.id,-10, -5)

# Make a hollow tower around your character (can be much bigger than cube without crashing performance)
def makeTower(squareSize, height, blockType, aboveGround=0):
	half = squareSize/2
	for y in range(0, height):
		for x in range(0,squareSize):
			for z in range(0,squareSize):
				print "\n"
				xPos, yPos, zPos = origin[0]+x-half, origin[1]+y+aboveGround, origin[2]+z-half
				if x == 0 or x == (squareSize-1):
					# print("make x block", origin[0]+x, origin[1]+y, origin[2]+z) # if you need to debug
					# print("x,z: ", x, z) # if you need to debug
					mc.setBlock(xPos, yPos, zPos, blockType)
				elif z == 0 or z == (squareSize-1):
						# print("make z block", origin[0]+x, origin[1]+y, origin[2]+z) # if you need to debug
						# print("x,z: ", x, z) # if you need to debug
						mc.setBlock(xPos, yPos, zPos, blockType)

# Make big tower of diamond around yourself. Make 4 units above you.
makeTower(10, 50, block.DIAMOND_BLOCK.id, 4)
