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
}