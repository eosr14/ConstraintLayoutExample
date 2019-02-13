

# 코딩 규칙
# 1. 리소스 네이밍 규칙
## 1.1 공통
 - 모든 리소스의 네이밍은 아래의 간단한 규칙을 따릅니다. WHAT_WHERE_DESCRIPTION_SIZE
  * WHAT : 자원이 실제로 무엇을 나타내는지 표시 (예 : MainActivity -> activity)
    * activity, fragment, view, item, layout 접두사를 사용
      * Fragment 내부에 Fragment가 들어간다면 DESCRIPTION을 적용, 나머지는 DESCRIPTION를 적용하지 않는다.
  * WHERE : 논리적으로 앱이 속한 위치 설명. 여러 화면에서 사용되는 경우 “all”로 표기, 
  여러 화면이 아닌 다른 리소스들은 서브클래스의 커스텀 부분을 사용 (예 : MainActivity -> main, BookDetailFragment ->  bookdetail )
  * DESCRIPTION : 한 화면에서의 여러 요소를 구분 (예 : title, content)
  * SIZE : Drawables, dimensions 리소스에서 선택적으로 사용합니다. (예 : 24dp, small)
  

CustomDialogFragment.kt
dialog_custom.xml
fragment_custom_dialog.xml



~~~
예)
activity_main_title.xml
fragment_bookdetail_title.xml
CustomDialogFragment.kt
dialog_custom.xml
fragment_custom_dialog.xml
~~~

## 1.2 String, Color
 - WHERE_DESCRIPTION_SIZE 또는 all_DESCRIPTION 규칙

~~~
예)
bookdetail_title : BookDetailFragment의 제목
all_infoicon : 일반적인 info 아이콘
~~~


## 1.3 id
  - WHAT_WHERE_DESCRIPTION로 구분
  - 간단한 의미의 이름을 사용하며 약어를 사용하지 않음
  
~~~
예)

tablayout_main : MainActivity의 TabLayout
imageview_menu_profile : 커스텀 MenuView의 프로필 이미지
textview_bookdetail_title : BookDetailFragment의 title TextView
~~~

## 1.4 Dimensions 
 - 기본적으로는 모든 Dimensions이 all을 기본으로 구분 WHAT_all_DESCRIPTION_SIZE
 - 특정 화면에서 사용할 경우는 WHAT_WHERE_DESCRIPTION_SIZE 
 - SIZE 접두사는 아래와 같은 용어를 사용합니다
   * width, height, size, margin, padding, elevation, keyline, textsize
~~~
예)
height_toolbar : 모든 툴바의 높이
textsize_medium : 모든 텍스트의 중간 크기
size_menu_icon_margin : 메뉴 아이콘의 마진
~~~

## 1.5 Drawable
 - WHAT_WHERE_DESCRIPTION로 구분
 - selector, shape, vector, animation-list등과 같은 경우는 리소스의 종류를 상단에 표기한 뒤 기능과 모양에 어울리는 이름을 자유롭게 추가한다.
 - 단 약어를 사용하지 않는다.
~~~
예)
shape_main_divider.xml
selector_popup_button.xml
animation_bookdetail_viewer.xml
~~~

## 1.6 Style
 - WHERE.DESCRIPTION로 구분
 - Style 명은 파스칼 표기법으로 첫 글자에 대문자를 넣습니다.
~~~
예)
Theme.Custom
DialogText.Title
~~~

# 2. 기본 코드 규칙
## 2.1 기본 베이스 
 - 변수, 함수명은 카멜 표기법을 따른다. 
 - 문장의 끝에 세미콜론(;)은 생략한다.
 - 패키지 디렉토리는 화면 단위로 구성한다.
 - public은 생략한다.

## 2.2 정렬  규칙
 - 탭 대신 4 space를 사용한다.
 -  괄호 공백 또는 연산자 공백은 안드로이드 스튜디오 자동 정렬 기능을 사용한다.
 - 중괄호는 개행하지 않는다.
 - 파라메타 한줄로 처리하고 개행 하지 않는다.
 - 클래스 내에서 인터페이스를 선언하는 경우 클래스 최상단의 위치한다.
 - 메소드 선언은 연관된 메소드끼리 함께 위치하도록 구성한다.
 - 클래스 내 위치 순서
~~~
1. 인터페이스 선언
2. 변수 선언 및 initializer 블록
3. 생성자
4. 메소드
5. Companion Object
~~~

## 2.3 네이밍 규칙
 - 클래스명은 파스칼 표기법을 따른다.
~~~
예) class MyClass { ... }
~~~
 - 상수명은 대문자 + '_' 로 스네이크 표기법을 따른다.
~~~
예) 
const val MAX_COUNT = 8
val USER_NAME_FIELD = "UserName"
~~~
 - 열거형의 데이터명은 대문자 + '_' 로 스테이크 표기법을 따른다.
~~~
예) enum class Color { COLOR_RED, COLOR_GREEN }
~~~
 - 싱글톤 객체의 변수명은 파스칼 표기법을 따른다.
~~~
예) val PersonComparator: Comparator<Person> = …
~~~
 - public 객체가 private 객체를 사용하는 경우 객체 앞에  _ 를 붙여 사용합니다
~~~
예)
private val _elementList = mutableListOf<Element>()

val elementList: List<Element>
   get() = _elementList
~~~
 - Overload된 함수를 선언할때 기본매개변수를 사용해서 함수를 선언하는 것을 지향합니다.
~~~
예)
fun foo(a: String = "a") { ... }
fun sum(i: Int = "1") { ... }
~~~
 - Modifier는 다음 순서로 입력한다.
~~~
public / protected / private / internal
expect / actual
final / open / abstract / sealed / const
external
override
lateinit
tailrec
vararg
suspend
inner
enum / annotation
companion
inline
infix
operator
data
~~~
- KEY/VALUE 속성의 네이밍
  - SharedPreferences의 KEY 속성은 대문자 'KEY'로 지정합니다.
  - Bundle 관련(Intent.putExtra, outState.putString 등)의 속성은 대문자 'EXTRA'로 지정합니다.
~~~
예)
 1. SharedPreferences
  -> private const val KEY_LOGIN = "key_login"
 2. Bundle 관련
  -> private const val EXTRA_PENDING_EMAIL = "extra_pending_email"
  -> private const val EXTRA_LOGIN = "extra_login"
~~~
