vector<string> extract_words(const string& sentence) {
        vector<string> ans;
        stringstream ss(sentence);
        string word;

        while (ss >> word) {
            ans.push_back(word);
        }

        return ans;
    }