package com.ninaestoye.findfun

import org.junit.runner.RunWith
import org.junit.runners.Suite

@RunWith(Suite::class)
@Suite.SuiteClasses(
    MainActivityTest::class,
    SettingsActivityTest::class
)
class ActivityTestSuite