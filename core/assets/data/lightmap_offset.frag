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

uniform LOWP float x;
uniform LOWP float y;
uniform LOWP float dst;

uniform LOWP float uTime;
uniform LOWP float zoom;
void main(){

	gl_FragColor.r=v_color;
	gl_FragColor.a=texture2D(u_texture, v_texCoords).a*100*v_color.a;

	
	

}