package com.an.test

import org.apache.spark.{SparkConf, SparkContext}

/**
  * Created by AN on 2018/8/10.
  */
object Demo1 {

  System.setProperty("hadoop.home.dir", "D:\\env\\hadoop2.6.5\\hadoop-2.6.5")

  def main(args: Array[String]): Unit = {

    val sparkConf = new SparkConf().setAppName("test").setMaster("local[*]")

    val sc = new SparkContext(sparkConf)

    // wordCount 代码测试
    test_flatmap(sc)

    sc.setJobDescription("wordcount 代码测试")

  }

  //单元测试
  def test_flatmap(sc: SparkContext): Unit = {

    //加载资源
    val source = sc.textFile("D:\\test\\wordcount\\test1.txt")
    //wordcount
    val count = source.flatMap(line => line.split(" ")).map(word => (word, 1)).reduceByKey(_ + _)
    //保存结果
    count.saveAsTextFile("d:/result/result1.txt")
    System.out.print(count.count())

  }
  //  # 测试得到pi值
  def get_pi(sc:SparkContext):Unit={

  }
  //  val 和 var的区别
  def val_var_test():Unit={

  }

}
