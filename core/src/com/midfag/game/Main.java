package com.midfag.game;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.Texture.TextureFilter;

import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.graphics.g3d.Shader;
import com.badlogic.gdx.graphics.glutils.ShaderProgram;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.midfag.entity.decorations.DecorBarrel;

public class Main extends Game {


    public static BitmapFont font;
    public static BitmapFont font_big;
    public static BitmapFont font_dot_console;
    
    public static ShapeRenderer shapeRenderer;
    public static ShapeRenderer shapeRenderer_static;
    
   // public static Shader shd;
    public static ShaderProgram shader_bloom;
    public static ShaderProgram shader_default;
    public static ShaderProgram shader_dissolve;
    public static ShaderProgram shader_time_slow;
    public static ShaderProgram shader_optic;
    
    public static ShaderProgram shader_light;
    
    public static ShaderProgram shader;
    
    //public static ShaderProgram shader_default;
    
	public static boolean script_activate=true;
	public static ShaderProgram shader_lightmap;
	public static ShaderProgram shader_lightmap_offset;
	//public static SpriteBatch batch_wheel;
    
	public Main(boolean _script)
	{
		script_activate=_script;
	}
	
    public void create() {


    	System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
    	
        Assets.load_assets();
        SysConfig.RegisterSSD();
        SysConfig.RegisterEntity();
        
        SysConfig.RegisterWeapon();
        SysConfig.RegisterWeaponAttribute();
        
        SysConfig.RegisterShield();
        SysConfig.RegisterShieldAttribute();
        
        SysConfig.RegisterModule();
        SysConfig.RegisterModuleAttribute();
        

        
        
        
        //Assets.music.play();
        
        shapeRenderer=new ShapeRenderer();
        shapeRenderer_static=new ShapeRenderer();
        
	        ShaderProgram.pedantic = false;
	       
	        
	        shader_light=new ShaderProgram(Gdx.files.internal("data/shader_light.vert"),(Gdx.files.internal("data/shader_light.frag")));
			if (!shader_light.isCompiled()) {System.err.println(shader_light.getLog()); shader_light=GScreen.batch_custom.getShader();}
	        
			shader=new ShaderProgram(Gdx.files.internal("data/d.vert"),(Gdx.files.internal("data/d.frag")));
			if (!shader.isCompiled()) {System.err.println(shader.getLog()); shader=GScreen.batch_custom.getShader();}
		
	        shader_time_slow=new ShaderProgram(Gdx.files.internal("data/d.vert"),(Gdx.files.internal("data/time_slow.frag")));
			if (!shader_time_slow.isCompiled()) {System.err.println(shader_time_slow.getLog()); shader_time_slow=GScreen.batch_custom.getShader();}
	       
			//shader_optic=new ShaderProgram(Gdx.files.internal("data/d.vert"),(Gdx.files.internal("data/optic.frag")));
			//if (!shader_optic.isCompiled()) {System.err.println(shader_optic.getLog()); shader_optic=GScreen.batch.getShader();}
			
			shader_dissolve=new ShaderProgram(Gdx.files.internal("data/d.vert"),(Gdx.files.internal("data/dissolve.frag")));
			if (!shader_dissolve.isCompiled()) {System.err.println(shader_dissolve.getLog()); shader_dissolve=GScreen.batch_custom.getShader();}
			
			shader_bloom=new ShaderProgram(Gdx.files.internal("data/d_new.vert"),(Gdx.files.internal("data/shader_bloom.frag")));
			if (!shader_bloom.isCompiled()) {System.err.println(shader_bloom.getLog()); shader_bloom=GScreen.batch_custom.getShader();}
			
			shader_lightmap=new ShaderProgram(Gdx.files.internal("data/d.vert"),(Gdx.files.internal("data/lightmap.frag")));
			if (!shader_lightmap.isCompiled()) {System.err.println(shader_lightmap.getLog()); shader_lightmap=GScreen.batch_custom.getShader();}
			
			shader_lightmap_offset=new ShaderProgram(Gdx.files.internal("data/d.vert"),(Gdx.files.internal("data/lightmap_offset.frag")));
			if (!shader_lightmap.isCompiled()) {System.err.println(shader_lightmap_offset.getLog()); shader_lightmap_offset=GScreen.batch_custom.getShader();}
			
			shader_default=new ShaderProgram(Gdx.files.internal("data/def.vert"),(Gdx.files.internal("data/def.frag")));
			if (!shader_default.isCompiled()) {System.err.println(shader_default.getLog()); shader_default=GScreen.batch_custom.getShader();}
        
        Texture texture = new Texture(Gdx.files.internal("data/fonts/big.png"));
        texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);// true enables mipmaps
        font_big = new BitmapFont(Gdx.files.internal("data/fonts/big.fnt"), new TextureRegion(texture), false);
        
        texture = new Texture(Gdx.files.internal("data/fonts/dot_console.png"));
        texture.setFilter(TextureFilter.Nearest, TextureFilter.Nearest);// true enables mipmaps
        font_dot_console = new BitmapFont(Gdx.files.internal("data/fonts/dot_console.fnt"), new TextureRegion(texture), false);
        
        texture = new Texture(Gdx.files.internal("data/rus.png"));
        texture.setFilter(TextureFilter.Linear, TextureFilter.Linear);// true enables mipmaps
        font = new BitmapFont(Gdx.files.internal("data/rus.fnt"), new TextureRegion(texture), false);
        
        this.setScreen(new GScreen(this));
        
        
        
       //shader_default=GScreen.batch_illum.createDefaultShader();
        
        /*
        Class clazz = DecorBarrel.class;
        Package p = clazz.getPackage();
        
        Package[] pc= p.getPackage("com.midfag").getPackages();
        
        p.getPackage("com.midfag").getPackages();
        System.out.println("! " + p.getName() + ";");
       
        
        
        for (int i=0; i<pc.length; i++)
        {
        	if (pc[i].getName().startsWith("com.midfag.entity")) {System.out.println("PACKAGE " + pc[i].getName()  + ";");}
        }
        */
        
        
        
        
        
    }

    public void render() {
        super.render(); //important!
    }

    public void dispose() {
    	GScreen.batch_custom.dispose();
        font.dispose();
    }

}