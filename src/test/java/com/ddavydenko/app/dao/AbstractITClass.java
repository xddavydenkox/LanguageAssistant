/**
 * 
 */
package com.ddavydenko.app.dao;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author ddavydenko
 *Abstract class for Annotations inheritance.
 */
@Transactional
@ContextConfiguration({ "classpath*:spring.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
@TransactionConfiguration(defaultRollback = true)
public abstract class AbstractITClass {

}
