package model;

import com.gegidze.countrycodeserver.entity.Node;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.notNullValue;

public class NodeTest {

    Node root;

    @BeforeEach
    void setUp() {
        root = new Node();
    }

    @Test
    void rootTest() {
        assertThat(root.getChildren().size(), is(equalTo(0)));
        assertThat(root, is(notNullValue()));
    }
}
