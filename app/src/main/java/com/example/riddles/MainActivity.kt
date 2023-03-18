package com.example.riddles
import android.content.Intent
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.view.isVisible
import com.example.riddles.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var riddles2 = 0
    var riddles3 = mutableListOf<Int>()
    private var launcher: ActivityResultLauncher<Intent>? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        var answerConst = ""
        var trueCounter = 0
        var falseCounter = 0
        var allCounter = 0

        binding.btnStatistic.setOnClickListener{
            val intent = Intent(this, StatisticActivity::class.java)
            intent.putExtra("trueCount", trueCounter.toString())
            intent.putExtra("falseCount", falseCounter.toString())
            intent.putExtra("allCount", allCounter.toString())
            startActivity(intent)
        }

        launcher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result: ActivityResult ->
                if (result.resultCode == RESULT_OK){
                    val answerFromUser = result.data?.getStringExtra("answer")
                    binding.tvAnswer.text = "$answerFromUser"
                    binding.btnGetRiddle.isEnabled = true
                    if (answerFromUser == answerConst)
                    {
                        binding.tvAnswer.setBackgroundColor(Color.GREEN)
                        ++trueCounter
                    }
                    else {
                        binding.tvAnswer.setBackgroundColor(Color.RED)
                        ++falseCounter
                    }
                    if (allCounter == 10)
                    {
                        binding.btnStatistic.isVisible = true
                        binding.btnGetRiddle.isVisible = false
                        binding.btnGiveAnswer.isVisible = false
                        binding.btnRepeat.isVisible = true
                        binding.btnExit.isVisible = true

                    }
                }
            }

        binding.btnGetRiddle.setOnClickListener{
            binding.tvAnswer.text=""
            binding.btnGiveAnswer.isEnabled = true
            binding.btnGetRiddle.isEnabled = false
            ++allCounter
            binding.tvRiddlesCounterBase.text = allCounter.toString()

        binding.btnRepeat.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            }

            binding.btnExit.setOnClickListener{
                finish()
            }

            while (true)
            {
                riddles2 = (1..10).random()
                if (riddles2 !in riddles3)
                {
                    riddles3.add(riddles2)
                    break
                }
            }

            when (riddles2){
                1 -> {binding.tvRiddles.text = "В Полотняной стране\n" +
                        "По реке Простыне\n" +
                        "Плывет пароход\n" +
                        "То назад, то вперед,\n" +
                        "А за ним такая гладь —\n" +
                        "Ни морщинки не видать."
                    answerConst = "Утюг"
                }
                2-> {
                    binding.tvRiddles.text = "В брюшке — баня,\n" +
                            "В носу — решето,\n" +
                            "Нос — хоботок,\n" +
                            "На голове — пупок,\n" +
                            "Всего одна рука\n" +
                            "Без пальчиков,\n" +
                            "И та — на спине\n" +
                            "Калачиком."
                    answerConst = "Чайник"
                }
                3-> {binding.tvRiddles.text = "Стоит дуб,\n" +
                        "В нем двенадцать гнезд,\n" +
                        "В каждом гнезде\n" +
                        "По четыре яйца,\n" +
                        "В каждом яйце\n" +
                        "По семи цыпленков."
                    answerConst = "Год"}
                4-> {binding.tvRiddles.text = "В синем небе светляки —\n" +
                            "Не дотянешь к ним руки.\n" +
                            "А один большой светляк\n" +
                            "Изогнулся, как червяк."
                    answerConst = "Звёзды и месяц"
                }
                5-> {
                    binding.tvRiddles.text = "Вдруг из черной темноты\n" +
                            "В небе выросли кусты.\n" +
                            "А на них-то голубые,\n" +
                            "Пунцовые, золотые\n" +
                            "Распускаются цветы\n" +
                            "Небывалой красоты.\n" +
                            "И все улицы под ними\n" +
                            "Тоже стали голубыми,\n" +
                            "Пунцовыми, золотыми,\n" +
                            "Разноцветными."
                    answerConst="Салют"
                }
                6-> {
                    binding.tvRiddles.text = "Вот иголки и булавки\n" +
                            "Выползают из-под лавки,\n" +
                            "На меня они глядят,\n" +
                            "Молока они хотят."
                    answerConst = "Ёж"
                }
                7-> {
                    binding.tvRiddles.text = "Страну чудес откроем мы\n" +
                            "И встретимся с героями\n" +
                            "В строчках,\n" +
                            "На листочках,\n" +
                            "Где станции на точках."
                    answerConst = "Книга"
                }
                8-> {
                    binding.tvRiddles.text = "Ёжик странный у Егорки\n" +
                            "На окне сидит в ведерке.\n" +
                            "День и ночь он дремлет,\n" +
                            "Спрятав ножки в землю."
                    answerConst = "Кактус"
                }
                9-> {
                    binding.tvRiddles.text = "Если день нахмурится,\n" +
                            "Если дождь пойдет —\n" +
                            "Выйдет он на улицу,\n" +
                            "Надо мной вспорхнет."
                    answerConst = "Зонт"
                }
                10-> {
                    binding.tvRiddles.text = "Ходят-ходят два дружка\n" +
                            "Вокруг белого кружка,\n" +
                            "Ходят-ходят,\n" +
                            "Не приходят,\n" +
                            "Мерят-мерят,\n" +
                            "Не измерят."
                    answerConst = "Часы"
                }
            }
        }
        binding.btnGiveAnswer.setOnClickListener{
            val intent = Intent(this, AnswersActivity::class.java)
            launcher?.launch(intent)
            binding.btnGiveAnswer.isEnabled = false
        }
    }
}