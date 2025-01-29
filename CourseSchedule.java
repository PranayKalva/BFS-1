class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        if(numCourses == 0) {
            return false;
        }

        int[] indegrees = new int[numCourses];
        Map<Integer, List<Integer>> map = new HashMap<>();
        int count = 0;
        for(int[] prerequisite: prerequisites){
            int to = prerequisite[0];
            int from = prerequisite[1];

            indegrees[to]++;
            if(!map.containsKey(from)) {
                map.put(from, new ArrayList<>());
            }
            map.get(from).add(to);
        }

        Queue<Integer> q = new LinkedList<>();

        for(int i=0; i<numCourses; i++){
            if(indegrees[i] == 0){
                count++;
                q.add(i);
            }
        }

        while(!q.isEmpty()){
            int val = q.poll();

            List<Integer> list = map.get(val);

            if(list == null){
                continue;
            }

            for(int i: list){
                indegrees[i]--;
                if(indegrees[i] == 0){
                    count++;
                    q.add(i);
                }
            }
        }

        return numCourses == count;
    }
}
