import java.util.List;

class BinarySearch {
    private List<Integer> list;

    public BinarySearch(List<Integer> list) {
        this.list = list;
    }

    public int indexOf(int target) throws ValueNotFoundException {
        int left = 0;
        int right = list.size() - 1;

        while (left <= right) {
            int mid = left + (right - left)/2;
            
            if (list.get(mid) > target) {
                right = mid - 1;
            } else if (list.get(mid) < target) {
                left = mid + 1;
            } else {
                return mid;
            }
        } 

        throw new ValueNotFoundException("Value not in array");
    }
}
