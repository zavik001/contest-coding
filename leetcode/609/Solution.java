// https://leetcode.com/problems/find-duplicate-file-in-system/description/

class Solution {
    public List<List<String>> findDuplicate(String[] paths) {
        Map<String, List<String>> contentToFileMap = new HashMap<>();

        for (String path : paths) {
            String[] parts = path.split(" ");
            String directory = parts[0];

            for (int i = 1; i < parts.length; i++) {
                int openBracket = parts[i].indexOf('(');
                int closeBracket = parts[i].indexOf(')');
                String fileName = parts[i].substring(0, openBracket);
                String content = parts[i].substring(openBracket + 1, closeBracket);

                String filePath = directory + "/" + fileName;

                contentToFileMap.putIfAbsent(content, new ArrayList<>());
                contentToFileMap.get(content).add(filePath);
            }
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> filePaths : contentToFileMap.values()) {
            if (filePaths.size() > 1) {
                result.add(filePaths);
            }
        }

        return result;
    }
}
