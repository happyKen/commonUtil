package com.common.myutil.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * 流式布局
 * Created by wangzekeng on 2017/8/27.
 */
public class FNFlowLayout extends ViewGroup {
    public static final int GRAVITY_LEFT = -1;
    public static final int GRAVITY_CENTER = 0;
    public static final int GRAVITY_RIGHT = 1;
    protected List<ViewBean> mAllViews = new ArrayList<ViewBean>();// 所有的子view
    protected List<RowBean> mRowList = new ArrayList<RowBean>();// 每一行的宽高
    private int mGravity = GRAVITY_LEFT;
    private int mDividerWidth = 0;//每个子view左右间距
    private int mDividerHeight = 0;//每行间距

    public FNFlowLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public FNFlowLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FNFlowLayout(Context context) {
        this(context, null);
    }

    public void setDividerWidth(int length) {
        if (length > 0) {
            mDividerWidth = length;
        }
    }

    public void setDividerHeight(int length) {
        if (length > 0) {
            mDividerHeight = length;
        }
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        mAllViews.clear();
        mRowList.clear();

        int sizeWidth = MeasureSpec.getSize(widthMeasureSpec);
        int sizeHeight = MeasureSpec.getSize(heightMeasureSpec);
        int modeWidth = MeasureSpec.getMode(widthMeasureSpec);
        int modeHeight = MeasureSpec.getMode(heightMeasureSpec);

        // wrap_content
        int wrapContentWidth = 0;
        int wrapContentHeight = 0;

        int rowWidth = 0;// 绘制行的宽

        int childCount = getChildCount();

        int rowNums = 0;

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() == View.GONE) {
                continue;
            }

            measureChild(childView, widthMeasureSpec, heightMeasureSpec);
            MarginLayoutParams lp = (MarginLayoutParams) childView
                    .getLayoutParams();

            int childWidth = childView.getMeasuredWidth() + lp.leftMargin
                    + lp.rightMargin;
            int childHeight = childView.getMeasuredHeight() + lp.topMargin
                    + lp.bottomMargin;

            int dividerWidth = 0;
            if (rowWidth == 0) {
                dividerWidth = 0;
            } else {
                dividerWidth = mDividerWidth;
            }

            if ((rowWidth + childWidth + dividerWidth) > (sizeWidth
                    - getPaddingLeft() - getPaddingRight())) {
                // 该行空间不够绘制，需要换行
                wrapContentWidth = Math.max(rowWidth, wrapContentWidth);// 最终宽度
                rowNums++;
                rowWidth = 0;
                dividerWidth = 0;
            }

            ViewBean viewBean = new ViewBean();
            viewBean.row = rowNums;
            viewBean.width = childWidth;
            viewBean.height = childHeight;
            viewBean.view = childView;
            mAllViews.add(viewBean);
            rowWidth = rowWidth + childWidth + dividerWidth;

            if (i == childCount - 1) {
                wrapContentWidth = Math.max(rowWidth, wrapContentWidth);
            }

        }

        for (int i = 0; i <= rowNums; i++) {
            int rowHeight = 0;// 绘制行的高
            for (ViewBean viewBean : mAllViews) {
                if (i == viewBean.row) {
                    rowHeight = Math.max(rowHeight, viewBean.height);
                }
            }
            wrapContentHeight += rowHeight;
        }
        wrapContentHeight = wrapContentHeight + mDividerHeight * rowNums;// 最终高度

        setMeasuredDimension(modeWidth == MeasureSpec.EXACTLY ? sizeWidth
                        : wrapContentWidth + getPaddingLeft() + getPaddingRight(),
                modeHeight == MeasureSpec.EXACTLY ? sizeHeight
                        : wrapContentHeight + getPaddingTop()
                        + getPaddingBottom());

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {

        mAllViews.clear();
        mRowList.clear();

        int maxWidth = getWidth();
        int childCount = getChildCount();
        int rowNums = 0;
        int rowWidth = 0;// 绘制行的宽
        int rowHeight = 0;// 绘制行的高

        for (int i = 0; i < childCount; i++) {
            View childView = getChildAt(i);
            if (childView.getVisibility() == View.GONE) {
                continue;
            }

            MarginLayoutParams lp = (MarginLayoutParams) childView
                    .getLayoutParams();

            int childWidth = childView.getMeasuredWidth() + lp.leftMargin
                    + lp.rightMargin;
            int childHeight = childView.getMeasuredHeight() + lp.topMargin
                    + lp.bottomMargin;

            int dividerWidth = 0;
            if (rowWidth == 0) {
                dividerWidth = 0;
            } else {
                dividerWidth = mDividerWidth;
            }

            if ((rowWidth + childWidth + dividerWidth) > (maxWidth
                    - getPaddingLeft() - getPaddingRight())) {
                // 该行空间不够绘制，需要换行
                RowBean rowBean = new RowBean();
                rowBean.row = rowNums;
                rowBean.width = rowWidth;
                rowBean.height = rowHeight;
                mRowList.add(rowBean);// 保存该行的宽高

                rowNums++;
                rowWidth = 0;
                rowHeight = 0;
                dividerWidth = 0;
            }

            ViewBean viewBean = new ViewBean();
            viewBean.row = rowNums;
            viewBean.width = childWidth;
            viewBean.height = childHeight;
            viewBean.view = childView;
            mAllViews.add(viewBean);
            rowWidth = rowWidth + childWidth + dividerWidth;
            rowHeight = Math.max(rowHeight, childHeight);

            if (i == childCount - 1) {
                RowBean rowBean = new RowBean();
                rowBean.row = rowNums;
                rowBean.width = rowWidth;
                rowBean.height = rowHeight;
                mRowList.add(rowBean);// 保存该行的宽高
            }

        }

        int left = getPaddingLeft();
        int top = getPaddingTop();

        //分行绘制每个子view
        for (int i = 0; i <= rowNums; i++) {
            if (mRowList.size() <= i) {
                return;
            }
            int curRowWidth = mRowList.get(i).width;// 这一行的宽度
            int curRowHeight = mRowList.get(i).height;// 这一行的高度
            switch (this.mGravity) {
                case GRAVITY_LEFT:
                    left = getPaddingLeft();
                    break;
                case GRAVITY_CENTER:
                    left = (maxWidth - curRowWidth) / 2 + getPaddingLeft();
                    break;
                case GRAVITY_RIGHT:
                    left = maxWidth - curRowWidth + getPaddingLeft();
                    break;
            }

            for (ViewBean viewBean : mAllViews) {
                if (viewBean.row == i) {
                    View child = viewBean.view;
                    if (child.getVisibility() == View.GONE) {
                        continue;
                    }

                    MarginLayoutParams lp = (MarginLayoutParams) child
                            .getLayoutParams();
                    int lc = left + lp.leftMargin;
                    int tc = top + lp.topMargin;
                    int rc = lc + child.getMeasuredWidth();
                    int bc = tc + child.getMeasuredHeight();

                    child.layout(lc, tc, rc, bc);

                    left = left + child.getMeasuredWidth() + lp.leftMargin
                            + lp.rightMargin + mDividerWidth;
                }
            }
            top = top + curRowHeight + mDividerHeight;
        }

    }

    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        LayoutParams p = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        return new MarginLayoutParams(p);
//		return new MarginLayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    private class ViewBean {
        int row;// 该view属于第几行，行数从0开始
        int width;// 该view的宽
        int height;// 该view的高
        View view;
    }

    private class RowBean {
        int row;// 第几行
        int width;// 行宽
        int height;// 行高
    }
}
