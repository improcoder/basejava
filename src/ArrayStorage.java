import java.util.Arrays;

/**
 * Array based storage for Resumes
 */
public class ArrayStorage {
    Resume[] storage = new Resume[10000];

    private int counterArraySize = 0;

    void clear() {
        Arrays.fill(storage, 0, counterArraySize, null);
        counterArraySize = 0;
    }

    void save(Resume r) {
        storage[counterArraySize] = r;
        counterArraySize++;
    }

    Resume get(String uuid) {
        int indexStorage;
        for (int i = 0; i < counterArraySize; i++){
            if(storage[i].uuid.equals(uuid)){
                indexStorage = i;
                return storage[indexStorage];
            }
        }
        return null;
    }

        void delete (String uuid){
            for (int i = 0; i < counterArraySize; i++) {
                if (storage[i].uuid.equals(uuid)) {
                    System.arraycopy(storage , i+1, storage, i, counterArraySize-i-1);
                    storage[counterArraySize-1] = null;
                    counterArraySize--;
                    break;
                }
            }
        }
    /**
     * @return array, contains only Resumes in storage (without null)
     */
    Resume[] getAll() {
        int count = 0;
        for (int i = 0; i < storage.length; i++){
            if(storage[i] != null)
                count++;
            else
                break;
        }
        Resume[] clone = new Resume[count];
        for(int i = 0; i < count; i++){
            clone[i] = storage[i];
        }
        return clone;
    }

    int size() {
        return counterArraySize;
    }
}
