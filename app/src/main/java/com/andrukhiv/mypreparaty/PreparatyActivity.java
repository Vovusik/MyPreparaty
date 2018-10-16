package com.andrukhiv.mypreparaty;

import android.app.Activity;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.inqbarna.tablefixheaders.TableFixHeaders;
import com.inqbarna.tablefixheaders.adapters.BaseTableAdapter;

import java.util.ArrayList;
import java.util.List;

public class PreparatyActivity extends Activity {

    static {
        AppCompatDelegate.setDefaultNightMode(
                AppCompatDelegate.MODE_NIGHT_AUTO);
    }

    private class TemperatureTypes {
        private final String name;
        private final List<Preparaty> list;

        TemperatureTypes(String name) {
            this.name = name;
            list = new ArrayList<Preparaty>();
        }

        public int size() {
            return list.size();
        }

        public Preparaty get(int i) {
            return list.get(i);
        }
    }

    private class Preparaty {
        private final String[] data;

        private Preparaty(String suma,
                          String brunka,
                          String tsvitinnya,
                          String dozrivannya,
                          String rozpuskannya,
                          String rozmyakshennya) {

            data = new String[]{
                    suma,
                    brunka,
                    tsvitinnya,
                    dozrivannya,
                    rozpuskannya,
                    rozmyakshennya};
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_preparaty);

        TableFixHeaders tableFixHeaders = (TableFixHeaders) findViewById(R.id.table);
        BaseTableAdapter baseTableAdapter = new TemperatureAdapter(this);
        tableFixHeaders.setAdapter(baseTableAdapter);
    }

    public class TemperatureAdapter extends BaseTableAdapter {

        private final TemperatureTypes familys[];

        // Текст заголовку колонки
        private final String headers[] = {
                "Препарат",
                "Діюча речовина",
                "Виробник",
                "Спектр дії",
                "Кратність застосування",
                "Строки до споживання"
        };

        // todo Ширина колонки - як вкласти у ресурси
        private final int[] widths = {
                130,
                140,
                120,
                100,
                160,
                150

        };

        private final float density;

        public TemperatureAdapter(Context context) {

            // Заповнення розділів таблиці
            familys = new TemperatureTypes[]{
                    new TemperatureTypes("Фунгіциди"),
                    new TemperatureTypes("Інсектициди"),
                    new TemperatureTypes("Гербіциди"),
                    new TemperatureTypes("Добрива"),
                    new TemperatureTypes("Акарициди"),
                    new TemperatureTypes("Скорочення")
            };

            density = context.getResources().getDisplayMetrics().density;

            // Заповнення колонок таблиці
            familys[0].list.add(new Preparaty("Делан", "дитіанон", "Basf", "М", "3", "30"));
            familys[0].list.add(new Preparaty("Полірам ДФ", "метирам", "Basf", "М", "2", "30"));
            familys[0].list.add(new Preparaty("Кумулюс ДФ", "сірка", "Basf", "О", "2", "30"));
            familys[0].list.add(new Preparaty("Орвего", "аметоктрадин, диметоморф", "Basf", "М", "3", "30"));
            familys[0].list.add(new Preparaty("Стробі", "крезоксим-метил", "Basf", "О, М", "3", "50"));
            familys[0].list.add(new Preparaty("Акробат МЦ", "диметоморф, манкоцеб", "Basf", "М", "3", "30"));
            familys[0].list.add(new Preparaty("Колліс", "крезоксим-метил, боскалід", "Basf", "О", "3", "50"));
            familys[0].list.add(new Preparaty("Кабріо Топ", "пiраклостробiн, метирам", "Basf", "О, М, А", "3", "30"));
            familys[0].list.add(new Preparaty("Акробат Топ", "дитіанон, диметоморф", "Basf", "М", "3", "30"));
            familys[0].list.add(new Preparaty("Топаз", "пенконазол", "Syngenta", "О", "4", "20"));
            familys[0].list.add(new Preparaty("Діналі (новий)", "дифеноконазол, цифлуфенамід", "Syngenta", "О, ЧГ, КР", "3", "30"));
            familys[0].list.add(new Preparaty("Дітан М-45", "манкоцеб", "Syngenta", "М", "5", "30"));
            familys[0].list.add(new Preparaty("Ридоміл Голд", "манкоцеб, металаксил-М", "Syngenta", "М", "3", "25"));
            familys[0].list.add(new Preparaty("Пергадо R (новий)", "мандіпропамід, оксихлорид міді", "Syngenta", "М, А", "3", "30"));
            familys[0].list.add(new Preparaty("Тіовіт Джет", "сірка вододисперсна", "Syngenta", "О, ПК", "4", "30"));
            familys[0].list.add(new Preparaty("Квадріс", "азоксистробін", "Syngenta", "М, О, СГ, ЧП, А", "3", "25"));
            familys[0].list.add(new Preparaty("Світч", "ципродиніл, флудиоксоніл", "Syngenta", "Г, М", "1-2", "7"));
            familys[0].list.add(new Preparaty("Хорус", "ципродиніл", "Syngenta", "М, О, СГ", "3", "7"));
            familys[0].list.add(new Preparaty("Натіво", "трифлоксістробін", "Bayer", "О, К, СГ", "2", "20"));
            familys[0].list.add(new Preparaty("Мелоді Дуо", "пробінеб, іпровалікарб", "Bayer", "М", "2", "50"));
            familys[0].list.add(new Preparaty("Фалькон", "тебуконазол, тридеаменол, спіроксамін", "Bayer", "О", "4", "30"));
            familys[0].list.add(new Preparaty("Флінт Стар", "трифлоксістробін, піриметаніл", "Bayer", "О, СГ", "3", "20"));
            familys[0].list.add(new Preparaty("Пасадобль", "флуопіколід, пропінеб", "Bayer", "М", "3", "50"));
            familys[0].list.add(new Preparaty("Тельдор", "фенгексамід", "Bayer", "СГ", "4", "15"));
            familys[0].list.add(new Preparaty("Антракол", "пропінеб", "Bayer", "ЧП, М, А", "3", "50"));
            familys[0].list.add(new Preparaty("Наутіл", "цимоксаніл", "Bayer", "М", "2", "30"));
            familys[0].list.add(new Preparaty("Блу Бордо", "сульфат міді", "Bayer", "М", "4", "30"));
            familys[0].list.add(new Preparaty("Скала", "піриметаніл", "Bayer", "СГ", "3", "30"));
            familys[0].list.add(new Preparaty("Танос", "цимоксаніл, фамоксадон", "Dupont", "М", "3", "30"));
            familys[0].list.add(new Preparaty("Талендо", "проквіназид", "Dupont", "О", "3", "30"));
            familys[0].list.add(new Preparaty("Талендо Екстра", "проквіназид, тетраконазол", "Dupont", "О", "3", "30"));
            familys[0].list.add(new Preparaty("Курзат М", "цимоксаніл, манкоцеб", "Dupont", "М", "3", "30"));
            familys[0].list.add(new Preparaty("Косайд 2000", "гідроксид міді", "Dupont", "М", "3", "30"));

            familys[1].list.add(new Preparaty("Масаї", "тебуфенпірад", "Basf", "К", "2", "30"));
            familys[1].list.add(new Preparaty("Номолт", "тефлубензурон", "Basf", "ГЛ", "2", "30"));
            familys[1].list.add(new Preparaty("Воліам Флексі", "тіаметоксам, хлорантраніліпрол", "Syngenta", "ВЛ, СК, СО", "2", "35"));
            familys[1].list.add(new Preparaty("Матч", "люфенурон", "Syngenta", "ГЛ", "3", "30"));
            familys[1].list.add(new Preparaty("Люфокс", "феноксикарб, люфенурон", "Syngenta", "ГЛ", "2", "30"));
            familys[1].list.add(new Preparaty("Карате Зеон", "лямбда-цигалотрин", "Syngenta", "ВЛ, КВ", "2", "20"));
            familys[1].list.add(new Preparaty("Дурсбан", "хлорпірифос", "Syngenta", "ВЛ, КЛ, П", "2", "40"));
            familys[1].list.add(new Preparaty("Проклейм", "емамектин бензоату", "Syngenta", "ГЛ", "2", "14"));
            familys[1].list.add(new Preparaty("Енжіо", "тіаметоксам, лямбда-цигалотрин", "Syngenta", "ЛФ, Т, СК", "2", "20"));
            familys[1].list.add(new Preparaty("Актеллік", "піриміфос–метилу", "Syngenta", "ЛФ", "2", "0"));
            familys[1].list.add(new Preparaty("Децис f-Люкс", "дельтаметрин", "Bayer", "ВЛ", "2", "20"));

            familys[2].list.add(new Preparaty("Ураган Форте", "калійної солі гліфосату", "Syngenta", "Б", "0", "0"));
            familys[2].list.add(new Preparaty("Фюзілад Форте", "флуазифоп–П–бутилу", "Syngenta", "З, Б", "1", "0"));
            familys[2].list.add(new Preparaty("Реглон Форте", "дикват іону", "Syngenta", "Б", "2", "0"));
            familys[2].list.add(new Preparaty("Люмакс", "метолахлор, тербутилазин, мезотріон", "Syngenta", "Б", "2", "0"));
            familys[2].list.add(new Preparaty("Баста", "глюфосинат амонію", "Bayer", "Б", "2", "0"));

            familys[3].list.add(new Preparaty("Ізабіон", "амінокислота, пептид", "Syngenta", "ПП", "3", "0"));

            familys[4].list.add(new Preparaty("Мовенто", "спіротетрамат", "Bayer", "Ц, Т, Ф, Ч", "2", "0"));

            familys[5].list.add(new Preparaty("А", "антракноз", "", "", "", ""));
            familys[5].list.add(new Preparaty("Б", "бур’ян", "", "", "", ""));
            familys[5].list.add(new Preparaty("ВЛ", "виноградна листокрутка", "", "", "", ""));
            familys[5].list.add(new Preparaty("ГЛ", "гронова листокрутка", "", "", "", ""));
            familys[5].list.add(new Preparaty("КВ", "квіткоїд", "", "", "", ""));
            familys[5].list.add(new Preparaty("КЛ", "кліщ", "", "", "", ""));
            familys[5].list.add(new Preparaty("КР", "краснуха", "", "", "", ""));
            familys[5].list.add(new Preparaty("ЛФ", "листкова філоксера", "", "", "", ""));
            familys[5].list.add(new Preparaty("М", "мільдью", "", "", "", ""));
            familys[5].list.add(new Preparaty("О", "оїдіум", "", "", "", ""));
            familys[5].list.add(new Preparaty("П", "попелиця", "", "", "", ""));
            familys[5].list.add(new Preparaty("ПП", "позакореневе підживлення", "", "", "", ""));
            familys[5].list.add(new Preparaty("ПК", "павутинний кліщ", "", "", "", ""));
            familys[5].list.add(new Preparaty("СГ", "сіра гниль", "", "", "", ""));
            familys[5].list.add(new Preparaty("СК", "скосар", "", "", "", ""));
            familys[5].list.add(new Preparaty("СО", "совка", "", "", "", ""));
            familys[5].list.add(new Preparaty("Т", "трубковерт", "", "", "", ""));
            familys[5].list.add(new Preparaty("Ч", "червець", "", "", "", ""));
            familys[5].list.add(new Preparaty("ЧП", "чорна плямистість", "", "", "", ""));
        }

        // Кількість строк
        @Override
        public int getRowCount() {
            return 76;
        }

        // Кількість колонок
        @Override
        public int getColumnCount() {
            return 5;
        }

        @Override
        public View getView(int row, int column, View convertView,
                            ViewGroup parent) {
            final View view;
            switch (getItemViewType(row, column)) {
                case 0:
                    view = getFirstHeader(row, column, convertView, parent);
                    break;
                case 1:
                    view = getHeader(row, column, convertView, parent);
                    break;
                case 2:
                    view = getFirstBody(row, column, convertView, parent);
                    break;
                case 3:
                    view = getBody(row, column, convertView, parent);
                    break;
                case 4:
                    view = getFamilyView(row, column, convertView, parent);
                    break;
                default:
                    throw new RuntimeException("wtf?");
            }
            return view;
        }

        private View getFirstHeader(int row, int column, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_table_header_first, parent, false);
            }
            ((TextView) convertView.findViewById(android.R.id.text1)).setText(headers[0]);
            return convertView;
        }

        private View getHeader(int row, int column, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_table_header, parent, false);
            }
            ((TextView) convertView.findViewById(android.R.id.text1)).setText(headers[column + 1]);
            return convertView;
        }

        private View getFirstBody(int row, int column, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_table_first, parent, false);
            }
            convertView.setBackgroundResource(row % 2 == 0 ? R.color.rowBackground : R.color.windowBackground);
            ((TextView) convertView.findViewById(android.R.id.text1)).setText(getDevice(row).data[column + 1]);
            return convertView;
        }

        private View getBody(int row, int column, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_table, parent, false);
            }
            convertView.setBackgroundResource(row % 2 == 0 ? R.color.rowBackground : R.color.windowBackground);
            ((TextView) convertView.findViewById(android.R.id.text1)).setText(getDevice(row).data[column + 1]);
            return convertView;
        }

        private View getFamilyView(int row, int column, View convertView, ViewGroup parent) {
            if (convertView == null) {
                convertView = getLayoutInflater().inflate(R.layout.item_table_group, parent, false);
            }
            final String string;
            if (column == -1) {
                string = getFamily(row).name;
            } else {
                string = "";
            }
            ((TextView) convertView.findViewById(android.R.id.text1)).setText(string);
            return convertView;
        }

        @Override
        public int getWidth(int column) {
            return Math.round(widths[column + 1] * density);
        }

        // todo Висота рядків - як вкласти у ресурси
        @Override
        public int getHeight(int row) {
            final int height;
            if (row == -1) {
                height = 55;
            } else if (isFamily(row)) {
                height = 30;
            } else {
                height = 45;
            }
            return Math.round(height * density);
        }

        @Override
        public int getItemViewType(int row, int column) {
            final int itemViewType;
            if (row == -1 && column == -1) {
                itemViewType = 0;
            } else if (row == -1) {
                itemViewType = 1;
            } else if (isFamily(row)) {
                itemViewType = 4;
            } else if (column == -1) {
                itemViewType = 2;
            } else {
                itemViewType = 3;
            }
            return itemViewType;
        }

        private boolean isFamily(int row) {
            int family = 0;
            while (row > 0) {
                row -= familys[family].size() + 1;
                family++;
            }
            return row == 0;
        }

        private TemperatureTypes getFamily(int row) {
            int family = 0;
            while (row >= 0) {
                row -= familys[family].size() + 1;
                family++;
            }
            return familys[family - 1];
        }

        private Preparaty getDevice(int row) {
            int family = 0;
            while (row >= 0) {
                row -= familys[family].size() + 1;
                family++;
            }
            family--;
            return familys[family].get(row + familys[family].size());
        }

        @Override
        public int getViewTypeCount() {
            return 5;
        }
    }
}