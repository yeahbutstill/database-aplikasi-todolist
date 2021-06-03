public class AplikasaiTodoList {

    public static String[] model = new String[10];
    public static java.util.Scanner scanner = new java.util.Scanner(System.in);
    public static void main(String[] args) {

        viewShowTodoList();

    }

    /**
     * Menampilkan todo list
     */
    public static void showTodoList() {

        System.out.println(""+
                "▀█▀ ▄▀▄ █▀▄ ▄▀▄   █   █ ▄▀▀ ▀█▀\n" +
                " █  ▀▄▀ █▄▀ ▀▄▀   █▄▄ █ ▄██  █");
        for (var i = 0; i < model.length; i++) {
            var todo = model[i];
            var no = i + 1;

            if (todo != null) {
                System.out.println(no + ". " + todo);
            }
        }

    }

    /**
     * Menambahkan todo ke list
     */
    public static void addTodoList(String todo) {

        // cek apakah model penuh
        var isFull = true;
        for (int i = 0; i < model.length; i++) {
            if (model[i] == null) {
                // model masih ada yang kosong
                isFull = false;
                break;
            }
        }

        // jika penuh, kita resize ukuran array 2x lipat
        if (isFull) {
            var temp = model;
            model = new String[model.length * 2];

            for (int i = 0; i < temp.length; i++) {
                model[i] = temp[i];
            }
        }

        //tambahkan ke posisi yang data array nya NULL
        for (var i = 0; i < model.length; i++) {
            if (model[i] == null) {
                model[i] = todo;
                break;
            }
        }

    }

    /**
     * Menghapus todo dari list
     */
    public static boolean removeTodoList(Integer numbers) {

        if ((numbers -1) >= model.length) {
            return false;
        } else if (model[numbers -1] == null) {
            return false;
        } else {
            for (int i = (numbers - 1); i < model.length; i++) {
                if (i == (model.length - 1)) {
                    model[i] = null;
                } else {
                    model[i] = model[i + 1];
                }
            }
            return true;
        }

    }

    public static String input(String info) {

        System.out.print(info + " : ");
        String data = scanner.nextLine();
        return data;

    }

    /**
     * Menampilkan view todo list
     */
    public static void viewShowTodoList() {

        while (true) {
            showTodoList();
            System.out.println("===============================");
            System.out.println("- MENU -");
            System.out.println("===============================");
            System.out.println("1. Tambah");
            System.out.println("2. Hapus");
            System.out.println("0. Keluar");

            var input = input("Pilih");
            if (input.equals("1")) {
                viewAddTodoList();
            } else if(input.equals("2")) {
                viewRemoveTodoList();
            } else if(input.equals("0")) {
                break;
            } else {
                System.out.println("Maaf tidak ada didaftar menu");
            }
        }

    }

    /**
     * Menampilkan view menambahkan todo list
     */
    public static void viewAddTodoList() {

        System.out.println("MENAMBAH TODO LIST");
        var todo = input("Todo (Tekan '0' Jika Batal)");
        if (todo.equals("0")) {
            // batal
        } else {
            System.out.println("===============================");
            addTodoList(todo);
        }

    }

    /**
     * Menampilkan view menghapus todo list
     */
    public static void viewRemoveTodoList() {

        System.out.println("MENGHAPUS TODO LIST");
        var numbers = input("Nomor yang dihapus (Tekan '0' Jika Batal)");
        if (numbers.equals("0")) {
            // batal
        } else {
            boolean success = removeTodoList(Integer.valueOf(numbers));
            if (!success) {
                System.out.println("===============================");
                System.out.println("Gagal menghapus todo list : " + numbers);
            }
        }

    }

}
