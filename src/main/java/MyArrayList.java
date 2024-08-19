public class MyArrayList<X> {

    private final int size = 10;

    private Object[] elements = new Object[size];

    private int arrayIndex = 0;

    /**
     * Метод добавляет в список новый элемент. В два раза увеличивает внутренний массив,
     * если добавляемых элементов больше, чем размер внутреннего массива
     *
     * @param element
     */
    public void add(X element) {
        if (arrayIndex == size) {
            Object[] newElements = new Object[size * 2];
            for (int i = 0; i < arrayIndex; i++) {
                newElements[i] = elements[i];
            }
            elements = newElements;
        }
        elements[arrayIndex++] = element;
    }

    /**
     * @param index
     * @return возвращает элемент по заданному индексу
     */
    public X get(int index) {
        return (X) elements[index];
    }

    /**
     * @return возвращает количество элементов
     */
    public int size() {
        return arrayIndex;
    }

    /**
     * Удаляет элемент из списка по индексу. После удаления элемента создается временный массив,
     * в который копируются все элементы, кроме удаленного
     *
     * @param index
     */
    public void remove(int index) {
        elements[index] = null;
        Object[] newElements = new Object[size - 1];
        int x = 0;
        for (int i = 0; i < elements.length; i++) {
            if (elements[i] != null) {
                newElements[x] = elements[i];
                x++;
            }
        }
        arrayIndex--;
        elements = newElements;
    }


    /**
     * Меняет значение в определенной ячейке списка
     *
     * @param index
     * @param element
     */
    public void set(int index, X element) {
        elements[index] = element;
    }

    /**
     * В методе создается новый список, в него кладем значения из списка вызывающего этот метод со значениями
     * от "fromIndex" до "toIndex"
     * @param fromIndex
     * @param toIndex
     * @return возвращает список со значениями от заданных параметров
     */
    public MyArrayList<X> subList(int fromIndex, int toIndex) {
        MyArrayList<X> myArrayList = new MyArrayList<>();
        for (int i = fromIndex; i < toIndex; i++) {
            myArrayList.add(get(i));
        }
        return myArrayList;
    }
}

