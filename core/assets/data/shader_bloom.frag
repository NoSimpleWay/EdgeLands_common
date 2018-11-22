#ifdef GL_ES   
    #define LOWP lowp
    precision mediump float;
#else
    #define LOWP
#endif

varying LOWP vec4 v_color;

uniform LOWP float x;

varying vec2 v_texCoords;
varying vec2 v_texCoordsz;


uniform sampler2D u_texture;
uniform sampler2D u_texture2;

uniform LOWP float value;
void main(){

	
		gl_FragColor.rgb=texture2D
		(
			u_texture2,v_texCoordsz+
			vec2
			(
				(0.5-texture2D(u_texture, v_texCoordsz).r),
				(-0.5+texture2D(u_texture, v_texCoordsz).g)
			)*texture2D(u_texture, v_texCoordsz).b*x
		).rgb;
		
		gl_FragColor.a=texture2D(u_texture, v_texCoordsz).a;
	
		gl_FragColor*=v_color;
	

	
	
	

}