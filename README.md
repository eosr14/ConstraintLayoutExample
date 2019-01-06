# ConstraintLayoutExample

# 1. ConstraintLayout의 도입 이유와 특징
 - 레이아웃 에디터와의 상호 연관을 시키기 위해 도입하게 되었다고 합니다.
 - 복잡한 레이아웃을 단순한 계층구조를 이용해 표현할 수 있습니다.
 - ID로 작업하기 쉽도록 조금 더 강력하고 유연하게 제공합니다.
 - 언번들로 제공이 되어 개발자에 맞게 버전을 사용할 수 있습니다.
 - 다양한 비율과 해상도를 대응하기 위해서 여러벌의 레이아웃을 만들어야했지만 하나의 레이아웃으로 다양한 
유스케이스에 대응이 되며, 단순한 계층구조로 이해하기 쉽고 퍼포먼스 향상에 도움이 된다고 합니다.

# 2-1 Relative Positioning (상대적 배치)
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


# 2-4 Circular positioning
# 2-5 Visibility behavior
# 2-6 Dimension constraints
# 2-7 Chains
# 2-8 Virtual Helpers objects
# 2-9 Optimizer
 
# 참고 
 - https://developer.android.com/reference/android/support/constraint/ConstraintLayout
 - https://academy.realm.io/kr/posts/constraintlayout-it-can-do-what-now/
 - https://www.charlezz.com/?p=669
