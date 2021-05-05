// Square Root Decomposition for finding minimum number.
#include <stdio.h>
#include <math.h>
#include <limits.h>
#define BLOCKLENGTH 1000

// Initializing. For GCC Compiler.
long long int block[BLOCKLENGTH] = { [0 ... (BLOCKLENGTH - 1)] = LLONG_MAX };
long long int blockSize;

long long int query(long long int *input, long long int n, long long int left, long long int right) {
    long long int min = LLONG_MAX;

    // If the left index doesn't start from a 0 or some other block left value,
    // then it will traverse from left upto the value where a new block starts,
    // as soon as we get new block left index, it will move on.
    while (left < right && left % blockSize != 0 && left != 0) {
        if (min > input[left]) {
            min = input[left];
        }

        left++;
    }

    // Now, when we have left index as some block's left index value and right as
    // block's right index value, then it will give directly result from block array.
    while ((left + blockSize) <= right) {
        if (min > block[left / blockSize]) {
            min = block[left / blockSize];
        }

        left += blockSize;
    }

    // Otherwise if it ends with other right value, that is not block's right value.
    while (left <= right) {
        if (min > input[left]) {
            min = input[left];
        }

        left++;
    }
    return min;
}

void preprocess (long long int *input, long long int n) {
    long long int i, blockIndex = -1;

    blockSize = sqrt(n);

    for (i = 0; i < n; i++) {
        if (i % blockSize == 0) {
            blockIndex += 1;
        }
        // Storing minimum value.
        if (block[blockIndex] > input[i]) {
            block[blockIndex] = input[i];
        }
    }
//    for (i = 0; i < n; i++) {
//        printf("%lld ", block[i]);
//    }
}

int main() {

    long long int n, numQuery, left, right, i, result;

    scanf("%lld %lld",&n, &numQuery);
    long long int input[n];

    for (i = 0; i < n; i++) {
        scanf("%lld", &input[i]);
    }

    preprocess(input, n);

    for (i = 0; i < numQuery; i++) {
        scanf("%lld %lld", &left, &right);
        result = query(input, n, left, right);
        printf("%lld\n", result);
    }

    return 0;
}