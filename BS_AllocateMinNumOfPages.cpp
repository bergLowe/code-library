// https://practice.geeksforgeeks.org/problems/allocate-minimum-number-of-pages0937/1
#include <bits/stdc++.h>
using namespace std;

// Always try to change isValid method in different question.
bool isValid(int arr[], int n, int m, int max) {
    int student = 1;
    int sum = 0;
    for (int i = 0; i < n; i++) {
        sum += arr[i];
        if (sum > max) {
            student++;
            sum = arr[i];
        }
        if (student > m) return false;
    }
    return true;
}

int findPages(int arr[], int n, int m)
{
    int start = *max_element(arr, arr + n);
    int end = 0;
    for (int i = 0; i < n; i++) {
        end += arr[i];
    }
    int mid, result;
    while (start <= end) {
        mid = start + (end - start) / 2;
        if (isValid(arr, n, m, mid)) {
            result = mid;
            end = mid - 1;
        } else {
            start = mid + 1;
        }
    }
    return result;
}