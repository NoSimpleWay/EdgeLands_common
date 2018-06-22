package com.midfag.game;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.math.Vector2;

public class Phys {
	public Vector2 start=new Vector2();
	public Vector2 end=new Vector2();
	
	public float len;
	
	public float dx;
	public float dy;
	
	public float dix;
	public float diy;
	
	public float subline_A;
	public float subline_B;
	
	public float summline;
	public float vector_mul;
	
	public float goal_x;
	public float goal_y;
	
	public Vector2 normal=new Vector2();
	public float angle;
	
	public Object parent;
	
	public boolean display;
	public boolean move_block=true;
	
	
	
	public Phys(Vector2 _s, Vector2 _e,boolean _path, Object _parent,boolean _display)
	{
		
		parent=_parent;
		
		start=_s;
		end=_e;
		
		angle=(float) (Math.toDegrees(Math.atan2(start.x-end.x, start.y-end.y))+90f);
		
    	if (start.x==end.x)
    	{start.x-=0.1f;}
    	
    	if (start.y==end.y)
    	{start.y-=0.1f;}
		
		float a=start.x-end.x;
    	float b=start.y-end.y;
    	

    	
		len=start.dst(end);

		
    	dx=a/b;//=0.1/-100=-0.001
		dy=b/a;//-100*0.1=-1 000
		
    	//float c=(float) Math.sqrt((a*a)+(b*b));
    	//angle=(float) (Math.toDegrees(Math.atan2(a, b))+90);
    	 
    	normal=new Vector2(start.x-(start.x-end.x)/2+(float)Math.sin(Math.toRadians(angle))*5,start.y-(start.y-end.y)/2+(float)Math.cos(Math.toRadians(angle))*5);
    	
    	
    	
    	int ps=GScreen.path_cell;
    	

    	
    	/*
    	if (_path)
    	for (float i=0; i<=1; i+=ps/len)
    	{
    		
    			int xx=Math.round((start.x+(end.x-start.x)*i)/ps);
    			int yy=Math.round((start.y+(end.y-start.y)*i)/ps);
    		
    		if ((xx>=0)&&(xx<300)&&(yy>=0)&&(yy<300))
    		{
    			GScreen.path[xx][yy]=920;
    		}
    		
    	}
		*/
		display=_display;
	}
	
	public void clear_path()
	{
		int ps=GScreen.path_cell;
    	for (float i=0; i<=1; i+=ps/len)
    	{
    		
    		if (( (int)((start.x+(end.x-start.x)*i)/ps)>=0 )&&( (int)((start.x+(end.x-start.x)*i)/ps)<300 ))
    		if (( (int)((start.y+(end.y-start.y)*i)/ps)>=0 )&&( (int)((start.y+(end.y-start.y)*i)/ps)<300 ))
    		{
    			
    			//GScreen.path[(int)((start.x+(end.x-start.x)*i)/ps)][(int)((start.y+(end.y-start.y)*i)/ps)]=0;
    		}
    		
    	}
	}
	
	public Phys is_contact(float _x1, float _y1, float _x2, float _y2,float _dx, float _dy, float _l)
	{

		if (Math.abs(dx)<Math.abs(dy))
		{
			subline_A=(_y1-start.y)*dx;//=(50-0)*-0.001=50*-0.001=-0.05
			subline_B=(_y2-start.y)*dx;//(50-100)*-0.001=-50*1000=0.05
			
			subline_A=_x1-start.x-subline_A;//=0-50--0.05=-50+0.05=50.05
			subline_B=_x2-start.x-subline_B;//=100-5-0.05=100-0.05=49.95
		}
		else
		{
			subline_A=(_x1-start.x)*dy;//=(0-50)*-1 000=-50*-1 000=50 000
			subline_B=(_x2-start.x)*dy;//=(100-50)*-1000=50*-1 000=-50 000
			
			subline_A=_y1-start.y-subline_A;//=0-0-50 000=0-50 000=-50 000
			subline_B=_y2-start.y-subline_B;//0-0--50 000=0+50 000=50 000
		}
		
		if ((subline_A<=0)^(subline_B<=0))
		{
	
			summline=Math.abs(subline_A)+Math.abs(subline_B);
		
			
			vector_mul=_l*(Math.abs(subline_A)/summline);
			
			
			goal_x=_x1+_dx*vector_mul;
			goal_y=_y1+_dy*vector_mul;
			
			if ((goal_x>Math.min(start.x,end.x))&&(goal_x<Math.max(start.x,end.x))&&(goal_y>Math.min(start.y,end.y))&&(goal_y<Math.max(start.y,end.y)))
			{
				/*
				Main.shapeRenderer.begin(ShapeType.Filled);
					Main.shapeRenderer.circle(goal_x,goal_y,1);
				Main.shapeRenderer.end();
	*/
	
			return this;
			}
		}
			return null;
		}
	
	public void draw()
	{	
			//Main.batch.begin();
				//Main.font.draw(Main.batch, ""+angle, start.x, start.y);
			//Main.batch.end();
		
			if (display)
			{
				

				Main.shapeRenderer.setColor(Color.WHITE);
				Main.shapeRenderer.rectLine(start,end,GScreen.camera.zoom/2.f);
				
				Main.shapeRenderer.setColor(Color.BLACK);
				Main.shapeRenderer.rectLine(
											start.x-(start.x-end.x)/2,
											start.y-(start.y-end.y)/2,
											start.x-(start.x-end.x)/2-GScreen.sinR(angle)*10, 
											start.y-(start.y-end.y)/2-GScreen.cosR(angle)*10,
											1.0f
											);
				
				Main.shapeRenderer.setColor(Color.GREEN);
				Main.shapeRenderer.rectLine(
											start.x-(start.x-end.x)/2,
											start.y-(start.y-end.y)/2,
											start.x-(start.x-end.x)/2-GScreen.sinR(angle)*10, 
											start.y-(start.y-end.y)/2-GScreen.cosR(angle)*10,
											0.5f
											);
				Main.shapeRenderer.setColor(Color.WHITE);
				//Main.shapeRenderer.line(start.x-(start.x-end.x)/2,start.y-(start.y-end.y)/2,normal.x,normal.y);
			
				//Main.shapeRenderer.line(end,normal);
				
				/*
				if (is_contact(_x1,_y1,_x2,_y2,_r)>=0)
				{
					Main.shapeRenderer.circle(goal_x,goal_y,vector_mul/50+1);
				}
				*/
				
			
			}
	}
}
