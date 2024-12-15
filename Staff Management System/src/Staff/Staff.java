package Staff;


    public class Staff {
        private String name = "Unknown";
        private int age = 0;
        private long id = 0;
        private String gender = "Unknown";
        private String position = "Unknown";
        private double income = 0.0;

        public Staff(String name, int age, long id, String gender, String position, double income) {
            setName(name);
            setAge(age);
            setId(id);
            setGender(gender);
            setPosition(position);
            setIncome(income);
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            if (name!= null) {
                if (name.length() > 20) {
                    this.name = name.substring(0, 20);
                } else {
                    this.name = name;
                }
            }
        }

        public int getAge() {
            return age;
        }

        public void setAge(int age) {
            if (age >= 18 && age <= 60) {
                this.age = age;
            }
        }

        public long getId() {
            return id;
        }

        public void setId(long id) {
            this.id = id;
        }

        public String getGender() {
            return gender;
        }

        public void setGender(String gender) {
            if ("male".equals(gender) || "female".equals(gender)) {
                this.gender = gender;
            }
        }

        public String getPosition() {
            return position;
        }

        public void setPosition(String position) {
            if("manager".equals(position)||"staff".equals(position)) {
                this.position = position;
            }

        }

        public double getIncome() {
            return income;
        }

        public void setIncome(double income) {
            this.income = income;
        }
    }

