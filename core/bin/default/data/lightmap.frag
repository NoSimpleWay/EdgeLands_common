//#ifdef ��������� ���� �������� �� ������ ���������, � ������ ��.���� ������ ������������ �� ��������(GL_ES) ��  
//������������ ������ ����������� (��������) ������.(highp � ������� ��������; mediump � ������� ��������; lowp � ������ ��������)
#ifdef GL_ES   
    #define LOWP lowp
    precision mediump float;
#else
    #define LOWP
#endif

varying LOWP vec4 v_color;
varying vec2 v_texCoords;
// sampler2D ��� ����������� ������ ������ �  glsl ��� ������� � ��������
uniform sampler2D u_texture;
uniform sampler2D u_texture2;
uniform sampler2D u_texture3;

uniform LOWP float x;
uniform LOWP float y;
uniform LOWP float dst;

uniform LOWP float uTime;
uniform LOWP float zoom;
void main(){

	gl_FragColor.rgb=texture2D(u_texture, v_texCoords)*texture2D(u_texture2, v_texCoords*vec2(0.11111,0.0)*zoom+vec2(x-0.11111/2.0*zoom,y-0.0777/2.0*zoom-0.005+0.0777*(texture2D(u_texture3, v_texCoords).r)));
	//gl_FragColor.rgb=texture2D(u_texture3, v_texCoords);
	gl_FragColor*=v_color;
	gl_FragColor.a=texture2D(u_texture, v_texCoords).a*v_color.a;

	
	

}