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
  if (!need)
  {
	gl_FragColor = v_color * texture2D(u_texture2, v_texCoords) * texture2D(u_texture, v_texCoords_new);
	//gl_FragColor.rgb+=texture2D(u_texture, v_texCoords_new).rgb/2;
  }
  else
  {gl_FragColor = v_color * texture2D(u_texture2, v_texCoords);}
}