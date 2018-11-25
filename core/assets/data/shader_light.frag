#ifdef GL_ES
#define LOWP lowp
precision mediump float;
#else
#define LOWP 
#endif
varying LOWP vec4 v_color;
varying vec2 v_texCoords;
varying vec2 v_texCoords_new;
uniform sampler2D u_texture;
uniform sampler2D u_texture2;

uniform bool need;

void main()
{
	gl_FragColor.rgb = texture2D(u_texture2, v_texCoords).rgb*(v_color.rgb) + texture2D(u_texture2, v_texCoords).rgb*texture2D(u_texture, v_texCoords_new).rgb*(1-v_color.rgb);
	gl_FragColor.a = v_color.a * texture2D(u_texture2, v_texCoords).a;
}