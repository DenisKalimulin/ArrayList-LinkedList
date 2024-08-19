public class MyLinkedList<X> {

    private static class Node<X> {

        private X data;
        private Node<X> next;

        public Node(X data) {
            this.data = data;
            this.next = null;
        }
    }

    private Node<X> head;
    private Node<X> tail;
    private int size;

    public MyLinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    /**
     * Метод создает новый узел, который будет содержать переданные в методо данные и ссылку равную null;
     * Далее проверяем пустой ли список. Если список пуст, то новый элемент будет и головой и хвостом.
     * Если в списке есть элементы то текущий хвост ссылается на новый узел
     * @param data
     */
    public void add(X data) {
        Node<X> newNode = new Node<>(data);
        if (this.head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    /**
     * Проверка пустой ли список. Если да, элемент удалить невозможно.
     * Сохраняются данные из текущего узла, после head указывает на следующий узел
     * если список стал пустым после удаления, то "tail" == null
     * @return возвращает удаленный узел
     */
    public X remove() {
        if (head == null) {
            System.out.println("Лист пуст");
        }

        X data = head.data;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        size--;
        return data;
    }

    /**
     *
     * @return возвращает длину списка
     */
    public int size() {
        return size;
    }


}
