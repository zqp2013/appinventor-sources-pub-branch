---
title: 指定组件的大小
layout: documentation
description: App Inventor 2 指定组件的大小
---

[&laquo; 返回首页](index.html)

## 指定组件的大小

When you create a visible component in the designer, you are typically given the opportunity to specify its height and width. There are four  choices:

1. Automatic: Size is chosen by the system
1. Fill parent: Size is chosen to fill the space available.
1. Size specified in pixels
1. Size in percent of Screen (not available for all components)

Since not all Android devices have the  same screen size, it's good to avoid specifying sizes numerically as pixels if possible.

The notions of Automatic and Fill parent carry over to components that can contain other components, such as vertical and horizontal arrangements, as described below.

### The Screen
The Screen component has a Scrollable property. When the Scrollable property is checked, the Screen component behaves like a VerticalArrangement whose Height property is set to Automatic. When the Scrollable property is not checked, the Screen component behaves like a VerticalArrangement whose Height property is specified in pixels.


### VerticalArrangement
In a VerticalArrangement, components are arranged along the vertical axis, left-aligned.

If a VerticalArrangement's Width property is set to Automatic, the actual width of the arrangement is determined by the widest component whose Width property is not set to Fill Parent. If a VerticalArrangement's Width property is set to Automatic and it contains only components whose Width properties are set to Fill Parent, the actual width of the arrangement is calculated using the automatic widths of the components. If a VerticalArrangement's Width property is set to Automatic and it is empty, the width will be 100.

If a VerticalArrangement's Height property is set to Automatic, the actual height of the arrangement is determined by the sum of the heights of the components. **If a VerticalArrangement's Height property is set to Automatic, any components whose Height properties are set to Fill Parent will behave as if they were set to Automatic.**

If a VerticalArrangement's Height property is set to Fill Parent or specified in pixels, any components whose Height properties are set to Fill Parent will equally take up the height not occupied by other components.

### HorizontalArrangement
In a HorizontalArrangement, components are arranged along the horizontal axis, vertically center-aligned.

If a HorizontalArrangement's Height property is set to Automatic, the actual height of the arrangement is determined by the tallest component whose Height property is not set to Fill Parent. If a HorizontalArrangment's Height property is set to Automatic and it contains only components whose Height properties are set to Fill Parent, the actual height of the arrangement is calculated using the automatic heights of the components. If a HorizontalArrangement's Height property is set to Automatic and it is empty, the height will be 100.

If a HorizontalArrangement's Width property is set to Automatic, the actual width of the arrangement is determined by the sum of the widths of the components. **If a HorizontalArrangement's Width property is set to Automatic, any components whose Width properties are set to Fill Parent will behave as if they were set to Automatic.**

If a HorizontalArrangement's Width property is set to Fill Parent or specified in pixels, any components whose Width properties are set to Fill Parent will equally take up the width not occupied by other components.

### TableArrangement
In a TableArrangement, components are arranged in a grid of rows and columns, with not more than one component visible in each cell. **If multiple components occupy the same cell, only the last one will be visible. Avoid inadvertently placing several components in a single cell.**

Within each row, components are vertically center-aligned.

The width of a column is determined by the widest component in that column. When calculating column width, the automatic width is used for components whose Width property is set to Fill Parent. **However, each component will always fill the full width of the column that it occupies.**

The height of a row is determined by the tallest component in that row whose Height property is not set to Fill Parent. If a row contains only components whose Height properties are set to Fill Parent, the height of the row is calculated using the automatic heights of the components.

### Canvas
Only Balls and ImageSprites can be placed in a Canvas. Each Ball and ImageSprite is positioned on the canvas based on its X and Y properties. A Ball's width and height is always the diameter of the ball. The actual width/height of an ImageSprite whose Width/Height property is set to Automatic or Fill Parent[a] will be the width/height of the image.
