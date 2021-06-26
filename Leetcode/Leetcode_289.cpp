class Solution {
public:
    void gameOfLife(vector<vector<int>> &board) {
        int m = board.size();
        int n = board[0].size();
        int cnt;
        vector<pair<int, int>> coor{{-1, 0}, {-1, 1}, {0, 1}, {1, 1}, {1, 0}, {1, -1}, {0, -1}, {-1, -1}};
        vector<vector<int>> res(m, vector<int> (n));
        pair<int, int> index;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                cnt = 0;
                for (int k = 0; k < coor.size(); k++) {
                    index = {i + coor[k].first, j + coor[k].second};
                    if (check(index, m, n)) {
                        if (board[index.first][index.second] == 1) cnt++;
                    }
                }
                if (board[i][j] == 0) {
                    if (cnt == 3) {
                        res[i][j] = 1;
                    } else {
                        res[i][j] = 0;
                    }
                } else {
                    if (cnt < 2 || cnt > 3) {
                        res[i][j] = 0;
                    } else {
                        res[i][j] = 1;
                    }
                }
            }
        }
        board = res;
    }

    bool check(pair<int, int> indexes, int m, int n) {
        if (indexes.first >= 0 && indexes.first < m && indexes.second >= 0 && indexes.second < n) {
            return true;
        }
        return false;
    }
};