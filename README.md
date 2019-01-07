# ConstraintLayoutExample

# 1. ConstraintLayout의 도입 이유와 특징
 - 레이아웃 에디터와의 상호 연관을 시키기 위해 도입하게 되었다고 합니다.
 - 복잡한 레이아웃을 단순한 계층구조를 이용해 표현할 수 있습니다.
 - ID로 작업하기 쉽도록 조금 더 강력하고 유연하게 제공합니다.
 - 언번들로 제공이 되어 개발자에 맞게 버전을 사용할 수 있습니다.
 - 다양한 비율과 해상도를 대응하기 위해서 여러벌의 레이아웃을 만들어야했지만 하나의 레이아웃으로 다양한 
유스케이스에 대응이 되며, 단순한 계층구조로 이해하기 쉽고 퍼포먼스 향상에 도움이 된다고 합니다.

# 2-1 Relative Positioning (상대적 배치) : <https://github.com/eosr14/ConstraintLayoutExample/blob/developer/app/src/main/res/layout/activity_main_relative_positioning.xml>
- 상대적인 배치는 RelativeLayout과 흡사하며 뷰와 뷰간의 제약조건을 통해 위치를 결정할 수 있습니다.
- 가로축 상의 배치는 left, right, start, end 속성으로 배치 가능
- 세로축 상의 배치는 top, bottom 속성으로 배치 가능
- 텍스트에 한해서 baseline을 지정하여 배치 가능
- 아래의 속성을 통해 배치를 할 수 있습니다.
  * layout_constraintLeft_toLeftOf
  * layout_constraintLeft_toRightOf
  * layout_constraintRight_toLeftOf
  * layout_constraintRight_toRightOf
  * layout_constraintTop_toTopOf
  * layout_constraintTop_toBottomOf
  * layout_constraintBottom_toTopOf
  * layout_constraintBottom_toBottomOf
  * layout_constraintBaseline_toBaselineOf
  * layout_constraintStart_toEndOf
  * layout_constraintStart_toStartOf
  * layout_constraintEnd_toStartOf
  * layout_constraintEnd_toEndOf

# 2-2 Margins (여백)
- 여백은 start, end, left, top, right, bottom 속성으로 줄 수 있습니다.
  * android:layout_marginStart
  * android:layout_marginEnd
  * android:layout_marginLeft
  * android:layout_marginTop
  * android:layout_marginRight. 
  * android:layout_marginBottom

- 연결된 뷰의 Visibility 의 상태가 숨김 상태(GONE)일 경우 여백을 따로 지정할 수 있습니다.
  * layout_goneMarginStart
  * layout_goneMarginEnd
  * layout_goneMarginLeft
  * layout_goneMarginTop
  * layout_goneMarginRight
  * layout_goneMarginBottom

# 2-3 Centering positioning (중앙 배치)
- 상하좌우의 상대적 배치를 부모뷰로 설정을 하여 중앙정렬을 할 수 있습니다.
  * app:layout_constraintBottom_toBottomOf="parent"
  * app:layout_constraintLeft_toLeftOf="parent"
  * app:layout_constraintRight_toRightOf="parent"
  * app:layout_constraintTop_toTopOf="parent" 

- Bias 라는 속성을 통해 이미 정렬된 뷰를 한쪽으로 치우치게 설정할 수 있습니다. 
  * layout_constraintHorizontal_bias
  * layout_constraintVertical_bias

- 중앙으로 설정된 뷰를 왼쪽으로 30% 치우치게 설정하는 속성
  * app:layout_constraintVertical_bias="0.3"
  * app:layout_constraintLeft_toLeftOf="parent"
  * app:layout_constraintRight_toRightOf="parent" 


# 2-4 Circular positioning (원형 배치)
- 한 뷰를 중점으로 다른 뷰의 중점을 배치할 수 있습니다. (각도와 거리값 필요)
  * layout_constraintCircle : 기준으로 참조할 View의 id
  * layout_constraintCircleRadius : 참조한 View와의 거리(반지름)
  * layout_constraintCircleAngle : 0부터 360까지 참조한 뷰로부터의 각도


# 2-5 Visibility Behavior (가시성에 따른 동작)
 - ConstraintLayout 내에 연결된 뷰들간의 하나의 뷰가 숨겨지면(GONE) ConstraintLayout에서 특정 처리를 하도록 설정되어 있습니다. (Margins 기능의 GONE상태의 여백을 지정하는 기능)
 - 레이아웃이 사이즈를 계산하고 그리기 위해서는 GONE 처리된 뷰는 기본적으로 하나의 점으로 취급되며, 기본적인 여백(Margins)은 0입니다.

# 2-6 Dimension Constraints (크기 및 치수에 대한 제약 조건)
 - ConstraintLayout 내에서 최소값과 최대값을 정의 할 수도 있습니다.
 - 해당 속성을 사용하기 위해서는 ConstraintLayout 내에서 layout_width, layout_height에 대한 값이 WRAP_CONTENT로 지정이 되어 있어야 합니다.
   * android:minWidth 최소 가로 길이
   * android:minHeight 최소 세로 길이
   * android:maxWidth 최대 가로 길이
   * android:maxHeight 최대 세로 길이

 - 뷰의 가로와 세로 사이즈는 크게 3가지의 방식으로 결정됩니다.
   * 수치를 직접 입력할 때
   * WRAP_CONTENT를 통해 뷰 스스로 사이즈를 결정 지을 때
   * 0dp를 입력하고 제약 조건에 의해 사이즈를 결정 지을 때(0dp = MATCH_CONSTRAINT)

 - ConstraintLayout에서 제약 조건 이용 시 MATCH_PARENT를 사용하지 않는 것을 권장합니다. 대신 left/right 또는 top/bottom 제약 조건과 함께 MATCH_CONSTRAINT를 이용하라고 추천합니다.

 - 가변적인 뷰 처리를 유지하기 위해 뷰를 레이아웃 밖으로 밀려나가지 않게 하기 위한 속성을 제공합니다.
   * app:layout_constrainedWidth=”true|false”
   * app:layout_constrainedHeight=”true|false”

 - MATCH_CONSTRAINT : 기본적인 동작은 MATCH_PARENT처럼 공간을 구성합니다. 하지만 몇몇 속성을 같이 쓴다면 기능이 조금 달라집니다.
   * layout_constraintWidth_min and layout_constraintHeight_min : WRAP_CONTENT처럼 동작하나 최소값을 가짐
   * layout_constraintWidth_max and layout_constraintHeight_max : WRAP_CONTENT처럼 동작하나 최대값을 가짐
   * layout_constraintWidth_percent and layout_constraintHeight_percent : 0에서 1까지 float 값을 입력하여 비율적으로 길이를 결정

 - 만약 뷰의 가로와 세로의 비율을 결정하고 싶다면 layout_constraintDimensionRatio 속성을 사용할 수 있습니다.
 - 가로와 세로를 둘다 MATCH_CONSTRAINT로 적용하는 경우 가로세로의 비율을 결정하고 싶은데 세로기준 또는 가로기준으로 비율을 정하고 싶다면 “H” 또는 “W”를 붙이고 콤마(,)를 찍은 뒤 비율을 지정하면 됩니다.
   * app:layout_constraintDimensionRatio="H,16:9"

# 2-7 Chains
# 2-8 Virtual Helpers objects
# 2-9 Optimizer

# 참고
 - https://developer.android.com/reference/android/support/constraint/ConstraintLayout
 - https://academy.realm.io/kr/posts/constraintlayout-it-can-do-what-now/
 - https://www.charlezz.com/?p=669
