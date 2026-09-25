class Solution {
    public List<String> braceExpansionII(String expression) {
        Set<String> set = parse(expression);
        List<String> res = new ArrayList<>(set);
        Collections.sort(res);
        return res;
    }

    private Set<String> parse(String expr) {
        Set<String> res = new HashSet<>();
        List<Set<String>> cur = new ArrayList<>();
        cur.add(new HashSet<>(Arrays.asList("")));

        int i = 0;
        while (i < expr.length()) {
            char c = expr.charAt(i);
            if (c == '{') {
                int j = i;
                int count = 0;
                while (j < expr.length()) {
                    if (expr.charAt(j) == '{')
                        count++;
                    if (expr.charAt(j) == '}')
                        count--;
                    if (count == 0)
                        break;
                    j++;
                }
                Set<String> sub = parse(expr.substring(i + 1, j));
                cur.add(sub);
                i = j + 1;
            } else if (c == ',') {
                res.addAll(combineGroup(cur));
                cur = new ArrayList<>();
                cur.add(new HashSet<>(Arrays.asList("")));
                i++;
            } else {
                int j = i;
                while (j < expr.length() && Character.isLowerCase(expr.charAt(j))) {
                    j++;
                }
                Set<String> sub = new HashSet<>(Arrays.asList(expr.substring(i, j)));
                cur.add(sub);
                i = j;
            }
        }
        res.addAll(combineGroup(cur));
        return res;
    }

    private Set<String> combineGroup(List<Set<String>> list) {
        Set<String> res = new HashSet<>();
        res.add("");
        for (Set<String> set : list) {
            Set<String> next = new HashSet<>();
            for (String s1 : res) {
                for (String s2 : set) {
                    next.add(s1 + s2);
                }
            }
            res = next;
        }
        return res;
    }
}