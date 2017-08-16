### CollapsingToolbarLayout的一些总结;

## 1.CoordinatorLayout - AppBarLayout - ToolBar
[参考:CoordinatorLayout-Behavior-作用详解-CSDN](http://blog.csdn.net/huachao1001/article/details/51554608)

[参考:Material Design之 AppbarLayout 开发实践总结-简书](http://www.jianshu.com/p/ac56f11e7ce1)


- CoordinatorLayout继承的是ViewGroup
- AppBarLayout继承的是LinearLayout
- CollapsingToolbarLayout继承FrameLayout
- ToolBar继承ViewGroup

> CoordinatorLayout->AppBarLayout->CollapsingToolbarLayout->View和Toolbar

> CoordinatorLayout->AppBarLayout->看需求添加子View(设置app:layout_scrollFlags控制滑动等等)


### CoordinatorLayout

CoordinatorLayout 继承于ViewGroup,它就是一个超级强大FrameLayout。CoordinatorLayout的作用就是协调子View。它有两种使用场景：
>   1,作为 一个应用顶层的装饰布局，也就是一个Activity Layout 的最外一层布局。

>   2,作为一个或多个有特定响应动作的容器。


### AppBarLayout
AppbarLayout继承自LinearLayout,它就是一个垂直方向的LinearLayout,在LinearLayout的基础上添加了一些材料设计的概念和特性，即滑动手势。它可以让你定制在某个可滑动的View（如：ScrollView ,ListView ,RecyclerView 等）滑动手势发生改变时，**内部的子View 该做什么动作。子View应该提供滑动时他们期望的响应的动作Behavior,通过setScrollFlags(int)，或者xml 中使用属性：**
```
app:layout_scrollFlags
```
> 注意：AppbarLayout 严重依赖于CoordinatorLayout，必须用于CoordinatorLayout 的直接子View，如果你将AppbarLayout 放在其他的ViewGroup 里面，那么它的这些功能是无效的。

### AppbarLayout 子View 的几种动作
AppbarLayout 可以定制当某个可滑动的View滑动手势改变时内部子View的动作，

> 子View通过app:layout_scrollFlags来指定。layout_scrollFlags有5种动作

**分别是 scroll,enterAlways,enterAlwaysCollapsed,exitUntilCollapsed,snap。**

- **scroll**
> 子View 添加layout_scrollFlags属性 的值scroll 时，这个View将会随着可滚动View（如：ScrollView,以下都会用ScrollView 来代替可滚动的View ）一起滚动，就好像子View 是属于ScrollView的一部分一样。

- **enterAlways**
> 子View 添加layout_scrollFlags属性 的值有enterAlways 时, 当ScrollView 向下滑动时，子View 将直接向下滑动，而不管ScrollView 是否在滑动。**向上滑动直接先出来顶部布局**

**注意：要与scroll 搭配使用，否者是不能滑动的**

- **enterAlwaysCollapsed**
> enterAlwaysCollapsed 是对enterAlways 的补充，当ScrollView 向下滑动的时候，滑动View（也就是设置了enterAlwaysCollapsed 的View）下滑至折叠的高度，当ScrollView 到达滑动范围的结束值的时候，滑动View剩下的部分开始滑动。这个折叠的高度是通过View的minimum height （最小高度）指定的。
**向上滑动的时候先滑出最小高度  至顶部再滑出其他View;**

**补充说明：要配合scroll｜enterAlways 一起使用**

- **exitUntilCollapsed**
> 当ScrollView 滑出屏幕时（也就时向上滑动时），滑动View先响应滑动事件，滑动至折叠高度，也就是通过minimum height 设置的最小高度后，就固定不动了，再把滑动事件交给 scrollview 继续滑动。

**补充说明：配合Scroll一起使用**

- **snap**
> 在滚动结束后，如果view只是部分可见，它将滑动到最近的边界。比如，如果view的底部只有25%可见，它将滚动离开屏幕，而如果底部有75%可见，它将滚动到完全显示。

**补充说明：配合Scroll一起使用**

---

## collapsingToolbarLayout

CollapsingToolbarLayout作用是提供了一个可以折叠的Toolbar，它继承至FrameLayout，给它设置layout_scrollFlags，它可以控制包含在CollapsingToolbarLayout中的控件(如：ImageView、Toolbar)在响应layout_behavior事件时作出相应的scrollFlags滚动事件(移除屏幕或固定在屏幕顶端)。


## 总结:

> 总的来说，CoordinatorLayout 是协调子View的，通过Behavior指定子View动作。AppbarLayout就是一个竖直方向的LinearLayout,只不过它添加了一些材料的概念和特性，可以定制子View的滑动。CollapsingToolbarLayout 是对Toolbar 的包装，它有5个特性，Collapsing title、Content scrim、Status bar scrim、Parallax scrolling children、Pinned position children。这个三个View配合使用，可以做出一些很炫酷的UI效果。需要注意的是： AppbarLayout 要作为CoordinatorLayout 的直接子View使用，而CollapsingToolbarLayout 要作为AppbarLayout 的直接子View 使用，否则，上面将的特性是没有效果的。

---

## 布局的属性;
### andorid:fitSystemWindow
- 1.fitsSystemWindow 默认是true，就是组件都在屏幕内，但是不包括statusBar。设置成false后，整个屏幕都可以放置组件，没有statusBar和window之分。

- 2.android:fitsSystemWindows=“true”在布局中占有最高权限，如果明确设置为true，style设置fits为false是无效的；同理，只在布局中设置fits而没有设置style也是无效的。


[参考:andorid:fitSystemWindow属性详解](http://www.jianshu.com/p/2db7ecc50495)

---


### Toolbar

- android:theme="@style/ThemeOverlay.AppCompat.Dark.ActionBar"
- app:popupTheme="@style/ThemeOverlay.AppCompat.Light"
- app:layout_scrollFlags="scroll|enterAlways" （AppBarLayout内的子布局通过设置该属性确定是否可滑动）
```
app:contentInsetLeft="0dp"
app:contentInsetStart="0dp"
```
**这两个属性可以把Toolbar默认左边距去除**

**说明：**
app:popupTheme，这个属性就是用来自定义我们弹出的菜单的样式，在之前的Actionbar的溢出菜单，我们是不能自定义他的样式的，只能根据你的theme来选择黑白两种，不能自己定义，现在我们可以定义弹出菜单的样式。

### CoordinatorLayout

- app:layout_scrollFlags （子布局设置是否可滑动）
- android:layout_gravity 属性控制组件在布局中的位置
- app:layout_behavior="@string/appbar_scrolling_view_behavior" 通知布局中包含滑动组件！

**子布局通过app:layout_scrollFlags确定是否可滑动.给需要滑动的组件设置app:layout_scrollFlags="scroll|enterAlways" 属性。**

### CollapsingToolbarLayout

- app:collapsedTitleGravity 指定折叠状态的标题如何放置，可选值:top、bottom等
- app:collapsedTitleTextAppearance="@style/TextAppearance.CollapsedTitle"
指定折叠状态标题文字的样貌
- app:expandedTitleTextAppearance="@style/TextAppearance.ExpandedTitle"
指定展开状态标题文字的样貌
- app:contentScrim="?attr/colorPrimaryDark"
指定CollapsingToolbarLayout完全被滚出到屏幕外时的ColorDrawable
- app:expandedTitleGravity  展开状态的标题如何放置
- app:titleEnabled指定是否显示标题文本
- app:toolbarId指定与之关联的ToolBar，如果未指定则默认使用第一个被发现的ToolBar子View
- app:expandedTitleMarginStart="10dp"
- app:expandedTitleMargin
- app:expandedTitleMarginBottom
- app:expandedTitleMarginEnd
展开状态改变标题文字的位置，通过margin设置
- app:layout_collapseParallaxMultiplier="0.7"
设置视差的系数，介于0.0-1.0之间。
- app:layout_collapseMode="pin"（子布局设置折叠模式）
有两种“pin”：固定模式，在折叠的时候最后固定在顶端；“parallax”：视差模式，在折叠的时候会有个视差折叠的效果。

**CollapsingToolbarLayout主要是提供一个可折叠的Toolbar容器，对容器中的不同View设置layout_collapseMode折叠模式，来达到不同的折叠效果。**
---

> 使用CoordinatorLayout 子View为AppBarLayout（继承LinearLayout）可在AppBarLayout内部定义我们想要的布局,利用属性app:layout_scrollFlags=""来控滑动。

**通过添加app:layout_scrollFlags=""来判断是否滚动**
