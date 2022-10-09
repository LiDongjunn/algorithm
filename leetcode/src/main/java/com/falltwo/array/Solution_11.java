package com.falltwo.array;

class Solution_11 {
    public int maxArea(int[] height) {
        int area = 0;
        int length = height.length;
        int left = 0;
        int right = length - 1;

        area = (right - left) * Math.min(height[left], height[right]);

        while (left < right){
            if ( height[left] < height[right] ){
                left++;
                area = Math.max(area, (right - left) * Math.min(height[left], height[right])) ;
            }else{
                right--;
                area = Math.max(area, (right - left) * Math.min(height[left], height[right])) ;
            }
        }
        return area;
    }

    public int maxArea2(int[] height) {
        int area = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right){
            area = height[left] < height[right] ?
                    Math.max(area, (right - left) * height[left++]) :
                    Math.max(area, (right - left) * height[right--]);
        }
        return area;
    }
}