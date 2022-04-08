package ex1;

    public class Singleton {
        private static Singleton instance; //наш объект
        private Singleton () {}; //закрытый конструктор
        public static  Singleton getInstance() {
            if (instance == null) { //если объект еще не создан
                instance = new Singleton(); //создаем
            }
            return instance; // вернуть ранее созданный объект
        }
    }


